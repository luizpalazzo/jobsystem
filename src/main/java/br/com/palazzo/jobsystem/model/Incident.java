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
@Table(name = "jobsystem_incident")
public class Incident {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "incident_seq")
	@SequenceGenerator(sequenceName = "incident_seq", allocationSize = 1, name = "incident_seq")
	private Long ticketNumber;
	
	@ManyToOne
	@JoinColumn(name = "script_id")
	private Script script;
	
	private String log;
	private IncidentStatus status;
	private LocalDate eventDate;
	
	public Long getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(Long ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public Script getScript() {
		return script;
	}
	public void setScript(Script script) {
		this.script = script;
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
	public LocalDate getEventDate() {
		return eventDate;
	}
	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}
	
	@Override
	public String toString() {
		return "Incident [ticketNumber=" + ticketNumber + ", script=" + script + ", log=" + log + ", status=" + status
				+ ", eventDate=" + eventDate + "]";
	}
	

}
