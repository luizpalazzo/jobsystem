package br.com.palazzo.jobsystem.controller;

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
import br.com.palazzo.jobsystem.model.Team;
import br.com.palazzo.jobsystem.model.form.FormJob;
import br.com.palazzo.jobsystem.service.JobService;
import br.com.palazzo.jobsystem.service.TeamService;

@Controller
@RequestMapping("/job")
public class JobController {
	
	TeamService teamService;
	JobService jobService;
	
	@Autowired
	public JobController(TeamService teamService, JobService jobService) {
		this.teamService = teamService;
		this.jobService = jobService;
	}

    @RequestMapping(value = "/insert" , method = RequestMethod.GET)
    public ModelAndView insert() {
    	ModelAndView mv = new ModelAndView("job/insert_job", "teams", teamService.findAll());
    	return mv;
    }
    
    @RequestMapping(value = "/insert" , method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<FormJob> saveJob(@RequestBody FormJob form) {

        System.out.println(form);
        
        Team monitoringTeam = teamService.findById(Long.valueOf(form.getMonitoringTeam())).get();
        Team incidentTeam = teamService.findById(Long.valueOf(form.getIncidentTeam())).get();
        
        Job job = new Job();
        
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
    	mv.addObject("selectedJob",job);
    	return mv;
    }
    
    @RequestMapping(value = {"/delete"}, method = RequestMethod.DELETE)
    public ResponseEntity<Job> deleteJob(@RequestBody Job job){
    	System.out.println("ID ->>>"+job.getId());
    		jobService.delete(job.getId());
    		return new ResponseEntity<Job>(job, HttpStatus.OK);
    }
}
