package com.projeto.faculdade.ColetaProjetos.controller;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.faculdade.ColetaProjetos.services.IClienteService;

@RestController
public class ClienteController{
	
	@Inject
	private IClienteService clienteService;
	
	/*	Coloquei abaixo um exemplo de metodo, 
	*	nessa classe adicionamos todos os caminhos que serão chamados pelo front 
	*/
	
	@RequestMapping(value="/cliente",
			produces= {"application/json"},
			method= RequestMethod.GET)
	public void buscarClientes(
			@NotNull @RequestParam(value="codigoCliente", required=true) Integer codigoCliente) {
		//DO SOME MAGIC
	}
	
	
}
