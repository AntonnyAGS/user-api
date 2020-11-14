package com.projeto.faculdade.ColetaProjetos.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class DadosProjetoModelRequest {

	private String projectName;
	private String description;
	private String type;
	private String date;
	private String projectStatus;
	
	
	public DadosProjetoModelRequest() {
	
	}


	
	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getProjectStatus() {
		return projectStatus;
	}


	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}


	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String titulo) {
		this.projectName = titulo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String descricao) {
		this.description = descricao;
	}
	public String getType() {
		return type;
	}
	public void setType(String tipo) {
		this.type = tipo;
	}
}
