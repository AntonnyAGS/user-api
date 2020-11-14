package com.projeto.faculdade.ColetaProjetos.model;

import java.util.List;

/**
 * Classe modelo responsável por capturar os dados de entrada
 * da aplicação
 *
 * @author João Vitor
 * @since 09/11/2020
 */
public class ClienteModelRequest {

	private List<DadosClienteModelRequest> usuario;

	public List<DadosClienteModelRequest> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<DadosClienteModelRequest> usuario) {
		this.usuario = usuario;
	}
}
