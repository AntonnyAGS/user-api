package com.projeto.faculdade.ColetaProjetos.services.impl;

import com.projeto.faculdade.ColetaProjetos.model.ClienteModel;
import com.projeto.faculdade.ColetaProjetos.services.IClienteService;
import javax.inject.Named;

public class ClienteServiceImpl implements IClienteService {

	/*	Podemos criar a interface Repository(que conversa com as classes @Entity)
	*	aqui e dar Inject
	*	@Inject
	*	IClienteRepository clienteRepo;
	*/
	
    @Override
    public ClienteModel cadastrarCliente(ClienteModel cadastroClienteDomainModelRequest) {
    	//DO SOME MAGIC!
    	return null;
    }
}
