package br.com.palazzo.jobsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.palazzo.jobsystem.model.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long>{

}
