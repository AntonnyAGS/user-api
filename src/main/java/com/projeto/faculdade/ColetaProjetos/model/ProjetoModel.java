package com.projeto.faculdade.ColetaProjetos.model;

import com.projeto.faculdade.ColetaProjetos.controller.validation.enumerator.TipoProjetoEnum;

public class ProjetoModel {
	
	private String projectName;
	private String description;
	private String type;
	private String date;
	private String projectStatus;
	
	
	public ProjetoModel() {
	
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



	public String getTitulo() {
		return projectName;
	}
	public void setTitulo(String titulo) {
		this.projectName = titulo;
	}
	public String getDescricao() {
		return description;
	}
	public void setDescricao(String descricao) {
		this.description = descricao;
	}
	public String getTipo() {
		return type;
	}
	public void setTipo(String tipo) {
		this.type = tipo;
	}

}
