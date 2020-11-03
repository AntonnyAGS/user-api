package com.projeto.faculdade.ColetaProjetos.usecase.service;

import com.projeto.faculdade.ColetaProjetos.usecase.domain.request.CadastroClienteDomainModelRequest;
import com.projeto.faculdade.ColetaProjetos.usecase.gateway.CadastroGataway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadatroClienteUseCaseSevice {

    @Autowired
    private CadastroGataway cadastroGataway;

    public void cadastrarCliente(CadastroClienteDomainModelRequest cadastroClienteDomainModelRequest){
        cadastroGataway.cadastrarCliente(cadastroClienteDomainModelRequest);
    }
}
