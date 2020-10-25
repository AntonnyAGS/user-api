package com.projeto.faculdade.ColetaProjetos.entrypoint.model.response;

/**
 * Classe responsável por montar
 * os campos de mensagem de erro
 *
 * @author João Vitor
 * @since 24/10/2020
 */
public class CampoMensagemErroModelResponse {

    private String campo;
    private String mensagem;
    private String valor;

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
