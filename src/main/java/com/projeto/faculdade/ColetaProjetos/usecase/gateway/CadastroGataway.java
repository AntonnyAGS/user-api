package com.projeto.faculdade.ColetaProjetos.usecase.gateway;

import com.projeto.faculdade.ColetaProjetos.usecase.domain.request.CadastroClienteDomainModelRequest;
import org.springframework.stereotype.Component;

@Component
public interface CadastroGataway {

    void cadastrarCliente(CadastroClienteDomainModelRequest cadastroClienteDomainModelRequest);
}
