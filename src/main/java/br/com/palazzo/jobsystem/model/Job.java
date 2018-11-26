package br.com.palazzo.jobsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "jobsystem_job")
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "script_seq")
	@SequenceGenerator(sequenceName = "script_seq", allocationSize = 1, name = "script_seq")
	private Long id;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String timeSchedule;
	
	@ManyToOne
	@JoinColumn(name = "monitoring_team")
	private Team monitoringTeam;
	
	@ManyToOne
	@JoinColumn(name = "incident_team")
	private Team incidentTeam;
	
	@NotEmpty
	private String code;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTimeSchedule() {
		return timeSchedule;
	}
	public void setTimeSchedule(String timeSchedule) {
		this.timeSchedule = timeSchedule;
	}
	public Team getMonitoringTeam() {
		return monitoringTeam;
	}
	public void setMonitoringTeam(Team monitoringTeam) {
		this.monitoringTeam = monitoringTeam;
	}
	public Team getIncidentTeam() {
		return incidentTeam;
	}
	public void setIncidentTeam(Team incidentTeam) {
		this.incidentTeam = incidentTeam;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Override
	public String toString() {
		return "Script [id=" + id + ", name=" + name + ", timeSchedule=" + timeSchedule + ", monitoringTeam="
				+ monitoringTeam + ", incidentTeam=" + incidentTeam + ", code=" + code + "]";
	}
	
}
