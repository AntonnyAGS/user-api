package com.projeto.faculdade.ColetaProjetos.entrypoint.model.response;

import java.util.List;

/**
 * Classe responsável por conter os campos de lançamento
 * de exceptions dentro da aplicação
 *
 * @author João Vitor
 * @since 24/10/2020
 */
public class MensagemErroModelResponse {

    private String campo;
    private String mensagem;
    private String codigo;
    private List<CampoMensagemErroModelResponse> campos;

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

    public List<CampoMensagemErroModelResponse> getCampos() {
        return campos;
    }

    public void setCampos(List<CampoMensagemErroModelResponse> campos) {
        this.campos = campos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
