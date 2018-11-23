package br.com.palazzo.jobsystem.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.palazzo.jobsystem.model.Job;
import br.com.palazzo.jobsystem.model.JobExecutionHistory;
import br.com.palazzo.jobsystem.model.JobStatus;
import br.com.palazzo.jobsystem.model.Team;
import br.com.palazzo.jobsystem.model.form.FormJob;
import br.com.palazzo.jobsystem.service.JobHistoryService;
import br.com.palazzo.jobsystem.service.JobService;
import br.com.palazzo.jobsystem.service.TeamService;

@Controller
@RequestMapping("/job")
public class JobController {


	TeamService teamService;
	JobService jobService;
	JobHistoryService executionService;
	
	@Autowired
	public JobController(TeamService teamService, JobService jobService, JobHistoryService executionService) {
		this.teamService = teamService;
		this.jobService = jobService;
		this.executionService = executionService;
	}

    @RequestMapping(value = "/insert" , method = RequestMethod.GET)
    public ModelAndView insert() {
    	ModelAndView mv = new ModelAndView("job/insert_job", "teams", teamService.findAll());
    	return mv;
    }
    
    @RequestMapping(value = "/insert" , method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<FormJob> saveJob(@RequestBody FormJob form) {

        System.out.println(form);
        System.out.println(form.getId());
        
        Team monitoringTeam = teamService.findById(Long.valueOf(form.getMonitoringTeam())).get();
        Team incidentTeam = teamService.findById(Long.valueOf(form.getIncidentTeam())).get();
        
        Job job = new Job();
        
        if(form.getId() != null) {
        	job.setId(Long.valueOf(form.getId()));
        }
        
        job.setCode(form.getCode());
        job.setName(form.getName());
        job.setTimeSchedule(form.getTimeSchedule());
        job.setMonitoringTeam(monitoringTeam);
        job.setIncidentTeam(incidentTeam);        
        
        jobService.save(job);
        
        return new ResponseEntity<FormJob>(form, HttpStatus.OK);
    }
    
    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public ModelAndView listJobs(){
		return new ModelAndView("job/list_jobs", "jobs",jobService.findAll());
	}
    
    @RequestMapping(value = {"/edit/{id}"}, method = RequestMethod.GET)
    public ModelAndView editJob(@PathVariable("id") Job job) {
    	System.out.println(job);
    	ModelAndView mv = new ModelAndView("job/edit_job");
    	mv.addObject("teams", teamService.findAll());
    	mv.addObject("job",job);
    	return mv;
    }
    
    @RequestMapping(value = {"/delete"}, method = RequestMethod.DELETE)
    public ResponseEntity<Job> deleteJob(@RequestBody Job job){
    	System.out.println("ID ->>>"+job.getId());
    		jobService.delete(job.getId());
    		return new ResponseEntity<Job>(job, HttpStatus.OK);
    }
    
    @RequestMapping(value = {"/execute"}, method = RequestMethod.POST)
    public ResponseEntity<Job> executeJob(@RequestBody Job job){
    	System.out.println("ID ->>>"+job.getId());
    	Optional<Job> jobtoExecute = jobService.findById(Long.valueOf(job.getId()));
    	System.out.println("CODE ->>>"+jobtoExecute.get().getCode());
    	
		JobExecutionHistory execution = new JobExecutionHistory();
		
		execution.setJob(job);
		execution.setStartDate(LocalDateTime.now());
		
    		try {
    			jobService.executeScript(jobtoExecute.get().getCode());
    			
    			execution.setEndDate(LocalDateTime.now());
    			execution.setStatus(JobStatus.SUCCESS);
    			
    			executionService.save(execution);
    			
				return new ResponseEntity<Job>(job, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				
				execution.setEndDate(LocalDateTime.now());
    			execution.setStatus(JobStatus.ERROR);
    			
    			executionService.save(execution);
    			
				//criar o ticket
				return new ResponseEntity<Job>(job, HttpStatus.BAD_REQUEST);
			}
    		
    }
}
