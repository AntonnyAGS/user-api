package com.projeto.faculdade.ColetaProjetos.entrypoint.controller.exception.enumerator;

/**
 * Classe responsável por conter as mensagens de erro
 * da aplicação
 *
 * @author João Vitor
 * @since 24/10/2020
 */
public enum ResponseHandlerExceptionEnum {
    ERRO_NA_VALIDACAO_DE_CAMPOS("Erro na validação de campos"),
    VALIDATION_ERROR("validation_error"),
    RECURSO_INEXISTENTE("Recurso Inexistente"),
    RECURSO_NAO_AUTORIZADO("Transação Não Processada"),
    ERRO_INESPERADO("Erro Inesperado"),
    SERVICO_INDISPONIVEL("Serviço Indisponível");

    private String textoException;

    /**
     * Construtor privado para evitar instanciacao
     *
     * @param textoException
     */
    private ResponseHandlerExceptionEnum(String textoException) {
        this.textoException = textoException;
    }

    /**
     * Método responsável por retornar textos default para exceptions
     *
     * @return {@code String} - Texto definido para a exception escolhida.
     */
    public String getTextoException() {
        return this.textoException;
    }
}
