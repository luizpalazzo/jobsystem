package br.com.palazzo.jobsystem.model;

public enum IncidentStatus {
	
	OPENED("Opened"),
	SOLVED("Solved"),
	CANCELLED("Cancelled");
	
	private String description;
	
	IncidentStatus(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}

}
