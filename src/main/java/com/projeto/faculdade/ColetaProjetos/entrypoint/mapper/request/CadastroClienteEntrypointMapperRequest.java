package com.projeto.faculdade.ColetaProjetos.entrypoint.mapper.request;

import com.projeto.faculdade.ColetaProjetos.entrypoint.model.request.CadastroClienteEntrypointModelRequest;
import com.projeto.faculdade.ColetaProjetos.usecase.domain.request.CadastroClienteDomainModelRequest;
import org.springframework.stereotype.Component;

@Component
public class CadastroClienteEntrypointMapperRequest {

    public static CadastroClienteDomainModelRequest converter(
                                    CadastroClienteEntrypointModelRequest cadastroClienteEntrypointModelRequest){

        CadastroClienteDomainModelRequest cadastroClienteDomainModelRequest = new CadastroClienteDomainModelRequest();
        cadastroClienteDomainModelRequest.setCnpj(cadastroClienteEntrypointModelRequest.getCnpj());
        cadastroClienteDomainModelRequest.setCompanyName(cadastroClienteEntrypointModelRequest.getNomeEmpresa());
        cadastroClienteDomainModelRequest.setCpf(cadastroClienteEntrypointModelRequest.getCpf());
        cadastroClienteDomainModelRequest.setEmail(cadastroClienteEntrypointModelRequest.getEmail());
        cadastroClienteDomainModelRequest.setName(cadastroClienteEntrypointModelRequest.getNome());
        cadastroClienteDomainModelRequest.setPassword(cadastroClienteEntrypointModelRequest.getSenha());
        cadastroClienteDomainModelRequest.setPhysicalPerson(cadastroClienteEntrypointModelRequest.getPessoaFisica());
        cadastroClienteDomainModelRequest.setSocialReason(cadastroClienteEntrypointModelRequest.getRazaoSocial());

        return cadastroClienteDomainModelRequest;
    }
}
