package br.com.palazzo.jobsystem.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "jobsystem_history")
public class JobExecutionHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "history_seq")
	@SequenceGenerator(sequenceName = "history_seq", allocationSize = 1, name = "history_seq")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "job_id")
	private Job job;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private JobStatus status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	public LocalDateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}
	public JobStatus getStatus() {
		return status;
	}
	public void setStatus(JobStatus status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "JobExecutionHistory [id=" + id + ", job=" + job + ", startDate=" + startDate + ", endDate="
				+ endDate + ", status=" + status + "]";
	}
	
	

}
