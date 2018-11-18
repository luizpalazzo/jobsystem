package br.com.palazzo.jobsystem.model.form;

public class FormJob {
	
	private String name;
	private String timeSchedule;
	private String monitoringTeam;
	private String incidentTeam;
	private String code;
	
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
	public String getMonitoringTeam() {
		return monitoringTeam;
	}
	public void setMonitoringTeam(String monitoringTeam) {
		this.monitoringTeam = monitoringTeam;
	}
	public String getIncidentTeam() {
		return incidentTeam;
	}
	public void setIncidentTeam(String incidentTeam) {
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
		return "Script [name=" + name + ", timeSchedule=" + timeSchedule + ", monitoringTeam=" + monitoringTeam
				+ ", incidentTeam=" + incidentTeam + ", code=" + code + "]";
	}

}
