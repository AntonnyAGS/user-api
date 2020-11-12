package com.projeto.faculdade.ColetaProjetos.controller.validation.enumerator;

import java.util.Objects;
import java.util.Optional;

public enum TipoProjetoEnum {
	APP("app"),
	SISTEMA("sistema"),
    SITE("site");

    private String tipoProjeto;

    TipoProjetoEnum(String tipoProjeto){
        this.tipoProjeto = tipoProjeto;
    }

    public String getTipoProjeto() {
        return tipoProjeto;
    }


    public static Optional<String> validaTipoProjeto(String tipoProjeto){

        if(Objects.nonNull(tipoProjeto)){
            for(TipoProjetoEnum tipoProjetoEnum : values()){
                if(tipoProjetoEnum.getTipoProjeto().equalsIgnoreCase(tipoProjeto)){
                    return Optional.of(tipoProjetoEnum.getTipoProjeto());
                }
            }
        }
        return Optional.empty();
    }

}
