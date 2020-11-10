package com.projeto.faculdade.ColetaProjetos.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

/**
 * Classe modelo responsável por capturar os dados de entrada
 * da aplicação
 *
 * @author João Vitor
 * @since 09/11/2020
 */
@JsonNaming(SnakeCaseStrategy.class)
public class ClienteModelRequest {

	private List<DadosClienteModelRequest> usuario;

	public List<DadosClienteModelRequest> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<DadosClienteModelRequest> usuario) {
		this.usuario = usuario;
	}
}
