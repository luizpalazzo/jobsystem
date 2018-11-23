package br.com.palazzo.jobsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.palazzo.jobsystem.model.JobExecutionHistory;
import br.com.palazzo.jobsystem.repository.JobExecutionHistoryRepository;

@Service
public class JobHistoryService {

	JobExecutionHistoryRepository repository;

	@Autowired
	public JobHistoryService(JobExecutionHistoryRepository repository) {
		this.repository = repository;
	}
	
	public void save(JobExecutionHistory execution) {
		repository.save(execution);
	}
	
	public List<JobExecutionHistory> findAll(){
		return repository.findAll();
	}
	
	
	
}
