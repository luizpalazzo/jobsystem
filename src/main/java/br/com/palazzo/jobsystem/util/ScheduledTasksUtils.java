package br.com.palazzo.jobsystem.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.palazzo.jobsystem.service.JobService;

@Component
public class ScheduledTasksUtils {
	
	JobService jobService;
		
	@Autowired
	public ScheduledTasksUtils(JobService jobService) {
		this.jobService = jobService;
	}

	@Scheduled(fixedRate = 60000)
    public void reportCurrentTime() {
        System.out.println("Iniciando TASK.......");
        jobService.executeScheduledJobs();
    }

}
