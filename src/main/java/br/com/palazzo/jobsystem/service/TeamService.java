package br.com.palazzo.jobsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.palazzo.jobsystem.model.Team;
import br.com.palazzo.jobsystem.repository.TeamRepository;

@Service
public class TeamService {
	
	TeamRepository repository;

	@Autowired
	public TeamService(TeamRepository repository) {
		this.repository = repository;
	}
	
	public List<Team> findAll(){
		return repository.findAll();
	}
	
	public Optional<Team> findById(long id) {
		return repository.findById(id);
	}	

}
