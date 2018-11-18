package br.com.palazzo.jobsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.palazzo.jobsystem.model.Job;
import br.com.palazzo.jobsystem.repository.JobRepository;

@Service
public class JobService {
	
	JobRepository repository;

	@Autowired
	public JobService(JobRepository repository) {
		this.repository = repository;
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

}
