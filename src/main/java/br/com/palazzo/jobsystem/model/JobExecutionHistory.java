package br.com.palazzo.jobsystem.model;

import java.time.LocalDate;

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
	@JoinColumn(name = "script_id")
	private Script script;
	private LocalDate startDate;
	private LocalDate endDate;
	private JobStatus status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Script getScript() {
		return script;
	}
	public void setScript(Script script) {
		this.script = script;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
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
		return "JobExecutionHistory [id=" + id + ", script=" + script + ", startDate=" + startDate + ", endDate="
				+ endDate + ", status=" + status + "]";
	}
	
	

}
