package br.com.palazzo.jobsystem.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.palazzo.jobsystem.model.Incident;
import br.com.palazzo.jobsystem.model.IncidentStatus;
import br.com.palazzo.jobsystem.model.Job;
import br.com.palazzo.jobsystem.repository.IncidentRepository;

@Service
public class IncidentService {

	IncidentRepository repository;

	@Autowired
	public IncidentService(IncidentRepository repository) {
		this.repository = repository;
	}
	
	public void save(Incident incident) {
		repository.save(incident);
	}
	
	public List<Incident> findAll(){
		return repository.findAll();
	}

	public String getLog(Long id) {
		Optional<Incident> incident = repository.findById(id);
		return incident.get().getLog();
	}
	
	public Incident findById(Long id) {
		return repository.findById(id).get();
	}
	
    public Incident createTicket(Job job, Exception e){
    	Incident incident = new Incident();
    	incident.setEventDate(LocalDateTime.now());
    	incident.setLog(e.toString());
    	incident.setJob(job);
    	incident.setStatus(IncidentStatus.OPENED);
    	return incident;
    }

}
