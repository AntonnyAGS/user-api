package com.projeto.faculdade.ColetaProjetos.services.interfaces;

import org.springframework.stereotype.Component;

import com.projeto.faculdade.ColetaProjetos.model.ClienteModelRequest;

/**
 * Classe responsável por conter o método
 * de contrato para o cadastro de um cliente
 *
 * @author João Vitor
 * @since 09/11/2020
 */
@Component
public interface CadastraClienteInterface {

    /**
     * Método de contrato da aplicação para o cadastro
     * de um cliente
     *
     * @param clienteModelRequest
     */
    void cadastrarCliente(ClienteModelRequest clienteModelRequest);
}
