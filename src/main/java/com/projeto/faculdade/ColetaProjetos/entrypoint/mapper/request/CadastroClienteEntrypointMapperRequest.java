package com.projeto.faculdade.ColetaProjetos.entrypoint.mapper.request;

import com.projeto.faculdade.ColetaProjetos.api.model.ClienteModelRequest;
import com.projeto.faculdade.ColetaProjetos.model.ClienteModel;

import org.springframework.stereotype.Component;

@Component
public class CadastroClienteEntrypointMapperRequest {

    public static ClienteModel converter(
                                    ClienteModelRequest cadastroClienteEntrypointModelRequest){

        ClienteModel cadastroClienteDomainModelRequest = new ClienteModel();
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
