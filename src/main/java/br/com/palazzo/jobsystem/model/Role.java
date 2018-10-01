package br.com.palazzo.jobsystem.model;

public enum Role {
	
	INCIDENTES("Analista de Incidentes"),
	PRODUCAO("Analista de Produção");
	
	private String name;
	
	Role(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

}
