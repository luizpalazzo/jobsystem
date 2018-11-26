package br.com.palazzo.jobsystem.service;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.palazzo.jobsystem.model.Job;
import br.com.palazzo.jobsystem.model.JobExecutionHistory;
import br.com.palazzo.jobsystem.model.JobStatus;
import br.com.palazzo.jobsystem.repository.JobRepository;
import br.com.palazzo.jobsystem.util.OracleUtils;

@Service
public class JobService {
	
	JobRepository repository;
	JobHistoryService executionService;
	IncidentService incidentService;

	@Autowired
	public JobService(JobRepository repository, JobHistoryService executionService, IncidentService incidentService) {
		this.repository = repository;
		this.executionService = executionService;
		this.incidentService = incidentService;
	}
	
	public List<Job> findAll(){
		return repository.findAll();
	}
	
	public Optional<Job> findById(long id) {
		return repository.findById(id);
	}
	
	public void save(Job script) {
		repository.save(script);
	}
	
	public void delete(long id) {
		repository.deleteById(id);
	}
    
    public void executeScript(String script) throws ClassNotFoundException, SQLException {
    	OracleUtils.executeScript(script);
    }
    
    public List<Job> findJobsToExecute(){
    	List<Job> allJobs = findAll();
    	List<Job> jobsToExecute = new ArrayList<>();
    	
    	LocalTime localTime = LocalTime.now();
    	
    	int hour = localTime.getHour();
    	int minute = localTime.getMinute();
    	
    	System.out.println("Hora atual: "+hour+" Minuto Atual: "+minute);
    	
    	for(Job job : allJobs) {
    		int jobHour = Integer.parseInt(job.getTimeSchedule().substring(0, 2));
    		int jobMinute = Integer.parseInt(job.getTimeSchedule().substring(3, 5));
    		System.out.println("Hora: "+jobHour+" Minuto: "+jobMinute);
    		if(jobHour == hour) {
    			System.out.print("Horario atual igual ao do job");
    			if(jobMinute == minute) {
    				System.out.print("Minuto atual igual ao do job");
    				jobsToExecute.add(job);
    			}
    		}
    	}
    	return jobsToExecute;
    }
    
    public void executeScheduledJobs() {
    	for(Job job : findJobsToExecute()) {
    		JobExecutionHistory execution = new JobExecutionHistory();
    		
    		execution.setJob(job);
    		execution.setStartDate(LocalDateTime.now());
    		
        		try {
        			executeScript(job.getCode());
        			
        			execution.setEndDate(LocalDateTime.now());
        			execution.setStatus(JobStatus.SUCCESS);
        			
        			executionService.save(execution);
    			} catch (Exception e) {
    				
    				execution.setEndDate(LocalDateTime.now());
        			execution.setStatus(JobStatus.ERROR);
        			
        			executionService.save(execution);
        			
    				incidentService.save(incidentService.createTicket(job, e));
    			}
    	}
    }

}
