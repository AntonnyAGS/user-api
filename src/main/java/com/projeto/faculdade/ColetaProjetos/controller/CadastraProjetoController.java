package com.projeto.faculdade.ColetaProjetos.controller;

import javax.validation.Valid;

import com.projeto.faculdade.ColetaProjetos.controller.validation.CadastraClienteValidator;
import com.projeto.faculdade.ColetaProjetos.controller.validation.CadastraProjetoValidator;
import com.projeto.faculdade.ColetaProjetos.model.ClienteModelRequest;
import com.projeto.faculdade.ColetaProjetos.model.ProjetoModel;
import com.projeto.faculdade.ColetaProjetos.model.ProjetoModelRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.projeto.faculdade.ColetaProjetos.services.interfaces.CadastraClienteInterface;
import com.projeto.faculdade.ColetaProjetos.services.interfaces.CadastraProjetoInterface;

/**
 * Classe responsável por capturar os dados de entrada
 * da aplicação para o cadastro de projetos
 *
 * @code Julio Henrique
 * @since 11/11/2020
 */
@RestController
public class CadastraProjetoController {
	
	@Autowired
	private CadastraProjetoInterface projetoService;

	@Autowired
	private CadastraProjetoValidator cadastraProjetoValidator;

	/**
	 * Método responsável por capturar requisições de cadastro de um projeto
	 *
	 * @param projetoModel
	 * @return @code ResponseEntity<String> - retorno do método
	 */
	@PostMapping(value = "/cadastra_projeto", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> cadastraProjeto(@Valid @RequestBody(required = false) ProjetoModelRequest projetoModel, MultipartFile photo, MultipartFile document) {

		cadastraProjetoValidator.validaBodyEntrada(projetoModel);
		projetoService.cadastrarProjeto(projetoModel);

		return new ResponseEntity<>(HttpStatus.OK);
	}
}
