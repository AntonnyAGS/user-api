package com.projeto.faculdade.ColetaProjetos.controller;

import javax.validation.Valid;

import com.projeto.faculdade.ColetaProjetos.controller.validation.CadastraClienteValidator;
import com.projeto.faculdade.ColetaProjetos.model.ClienteModelRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projeto.faculdade.ColetaProjetos.services.interfaces.CadastraClienteInterface;

/**
 * Classe responsável por capturar os dados de entrada
 * da aplicação para o cadastro do cliente
 *
 * @code João Vitor
 * @since 09/11/2020
 */
@RestController
public class CadastraClienteController {
	
	@Autowired
	private CadastraClienteInterface clienteService;

	@Autowired
	private CadastraClienteValidator cadastraClienteValidator;

	/**
	 * Método responsável por capturar requisições de cadastro de um cliente
	 *
	 * @param clienteModelRequest
	 * @return @code ResponseEntity<String> - retorno do método
	 */
	@PostMapping(value = "/cadastra_cliente", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> cadastraTransacao(@Valid @RequestBody(required = false) ClienteModelRequest clienteModelRequest) {

		cadastraClienteValidator.validaBodyEntrada(clienteModelRequest);
		clienteService.cadastrarCliente(clienteModelRequest);

		return new ResponseEntity<>(HttpStatus.OK);
	}
}
