package com.projeto.faculdade.ColetaProjetos.model;

import java.util.List;

/**
 * Classe modelo responsável por capturar os dados de entrada
 * da aplicação
 *
 * @author João Vitor
 * @since 09/11/2020
 */
public class ProjetoModelRequest {

	private List<DadosProjetoModelRequest> projeto;

	public List<DadosProjetoModelRequest> getProjeto() {
		return projeto;
	}

	public void setProjeto(List<DadosProjetoModelRequest> projeto) {
		this.projeto = projeto;
	}
}
