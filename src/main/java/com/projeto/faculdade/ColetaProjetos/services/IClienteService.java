package com.projeto.faculdade.ColetaProjetos.services;

import org.springframework.stereotype.Component;

import com.projeto.faculdade.ColetaProjetos.model.ClienteModel;

@Component
public interface IClienteService {

    public ClienteModel cadastrarCliente(ClienteModel clienteModelRequest);
}
