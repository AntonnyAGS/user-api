package com.projeto.faculdade.ColetaProjetos.controller.validation;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.projeto.faculdade.ColetaProjetos.controller.exception.ParametroInvalidoException;
import com.projeto.faculdade.ColetaProjetos.model.DadosProjetoModelRequest;

import com.projeto.faculdade.ColetaProjetos.model.ProjetoModelRequest;

@Component
public class CadastraProjetoValidator {
	
	public void validaBodyEntrada(ProjetoModelRequest projetoModel) {
        List<DadosProjetoModelRequest> dadosProjetoModelRequest = projetoModel.getProjeto();

        if(!dadosProjetoModelRequest.isEmpty()){
            for(DadosProjetoModelRequest dados : dadosProjetoModelRequest){
                validaCamposProjeto(dados);
            }
        } else {
            throw new ParametroInvalidoException();
        }
    }
	
	private void validaCamposProjeto(DadosProjetoModelRequest dados) {
        if(Objects.isNull(dados.getProjectName())
            || Objects.isNull(dados.getDescription())){

            throw new ParametroInvalidoException();
        }
        
    }

}
