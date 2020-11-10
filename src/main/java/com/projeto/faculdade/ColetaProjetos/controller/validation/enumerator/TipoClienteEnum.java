package com.projeto.faculdade.ColetaProjetos.controller.validation.enumerator;

import java.util.Objects;
import java.util.Optional;

/**
 * Enum responsável por conter os tipos de cliente disponivel
 * pela aplicação
 *
 * @author João Vitor
 * @since 09/11/2020
 */
public enum TipoClienteEnum {
    PESSOA("pessoa"),
    EMPRESA("empresa");

    private String tipoCliente;

    TipoClienteEnum(String tipoCliente){
        this.tipoCliente = tipoCliente;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    /**
     * Método responsável por validar se o tipo cliente
     * enviado é existente
     *
     * @param tipoCliente
     * @return @code Optional<String> - tipo cliete
     */
    public static Optional<String> validaTipoCliente(String tipoCliente){

        if(Objects.nonNull(tipoCliente)){
            for(TipoClienteEnum tipoClienteEnum : values()){
                if(tipoClienteEnum.getTipoCliente().equalsIgnoreCase(tipoCliente)){
                    return Optional.of(tipoClienteEnum.getTipoCliente());
                }
            }
        }
        return Optional.empty();
    }
}
