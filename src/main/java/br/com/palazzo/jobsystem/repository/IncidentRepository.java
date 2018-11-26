package br.com.palazzo.jobsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.palazzo.jobsystem.model.Incident;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, Long>{

}
