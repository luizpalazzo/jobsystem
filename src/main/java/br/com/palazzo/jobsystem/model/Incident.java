package br.com.palazzo.jobsystem.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "jobsystem_incident")
public class Incident {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "incident_seq")
	@SequenceGenerator(sequenceName = "incident_seq", allocationSize = 1, name = "incident_seq")
	private Long ticketNumber;
	
	@ManyToOne
	@JoinColumn(name = "script_id")
	private Job job;
	
	@Column(length = 1500)
	private String log;
	private IncidentStatus status;
	private LocalDateTime eventDate;
	private String closure;
	
	public Long getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(Long ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public String getLog() {
		return log;
	}
	public void setLog(String log) {
		this.log = log;
	}
	public IncidentStatus getStatus() {
		return status;
	}
	public void setStatus(IncidentStatus status) {
		this.status = status;
	}
	public LocalDateTime getEventDate() {
		return eventDate;
	}
	public void setEventDate(LocalDateTime eventDate) {
		this.eventDate = eventDate;
	}
	public String getClosure() {
		return closure;
	}
	public void setClosure(String closure) {
		this.closure = closure;
	}
	
	@Override
	public String toString() {
		return "Incident [ticketNumber=" + ticketNumber + ", job=" + job + ", log=" + log + ", status=" + status
				+ ", eventDate=" + eventDate + ", closure=" + closure + "]";
	}

}
