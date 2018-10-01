package br.com.palazzo.jobsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.palazzo.jobsystem.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByUsername(String username);

}
