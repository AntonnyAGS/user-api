package com.projeto.faculdade.ColetaProjetos.services.interfaces;

import org.springframework.stereotype.Component;

import com.projeto.faculdade.ColetaProjetos.model.ProjetoModelRequest;

@Component
public interface CadastraProjetoInterface {
	
	void cadastrarProjeto(ProjetoModelRequest projetoModel);

}
