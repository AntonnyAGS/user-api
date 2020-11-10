package com.projeto.faculdade.ColetaProjetos.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe de excecao responsável por simbolizar o erro de
 * requisicoes formadas incorretamente <b>400</b>
 *
 * @author João Vitor
 * @since 09/11/2020
 *
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ParametroInvalidoException extends RuntimeException {

    /**
     * Constante para serializacao
     */
    private static final long serialVersionUID = -9065068160299041936L;

    /**
     * Construtor da classe para a mensamge e causa da excecao
     *
     * @param mensagem {@code String}
     * 		- mensagem referente ao erro
     *
     * @param causa {@code Throwable}
     * 		- causa da excecao
     */
    public ParametroInvalidoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

    /**
     * Construtor para montar a mensagem de saida
     */
    public ParametroInvalidoException() {
    }
}
