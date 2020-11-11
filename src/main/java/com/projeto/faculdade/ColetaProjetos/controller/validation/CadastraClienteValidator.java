package com.projeto.faculdade.ColetaProjetos.controller.validation;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.projeto.faculdade.ColetaProjetos.controller.exception.ParametroInvalidoException;
import com.projeto.faculdade.ColetaProjetos.controller.validation.enumerator.TipoClienteEnum;
import com.projeto.faculdade.ColetaProjetos.model.ClienteModelRequest;
import com.projeto.faculdade.ColetaProjetos.model.DadosClienteModelRequest;

@Component
public class CadastraClienteValidator {

    public void validaBodyEntrada(ClienteModelRequest clienteModelRequest) {
        List<DadosClienteModelRequest> dadosClienteModelRequest = clienteModelRequest.getUsuario();

        if(!dadosClienteModelRequest.isEmpty()){
            for(DadosClienteModelRequest dados : dadosClienteModelRequest){
                validaCamposUsuario(dados);
                validaCampos(dados);
            }
        } else {
            throw new ParametroInvalidoException();
        }
    }

    private void validaCamposUsuario(DadosClienteModelRequest dados) {
        if(Objects.isNull(dados.getEmail())
            || Objects.isNull(dados.getNome())
            || Objects.isNull(dados.getTelefone())
            || Objects.isNull(dados.getSenha())
            || validaSenha(dados.getSenha())){

            throw new ParametroInvalidoException();
        }
        
    }

    private void validaCampos(DadosClienteModelRequest dadosClienteModelRequest) {

        Optional<String> tipoClienteEnum = TipoClienteEnum.validaTipoCliente(dadosClienteModelRequest.getTipoCliente());

        if(tipoClienteEnum.isPresent()){
            tipoClienteValid(dadosClienteModelRequest);
        } else{
            throw new ParametroInvalidoException();
        }
    }

    private void tipoClienteValid(DadosClienteModelRequest dadosClienteModelRequest) {
        if(dadosClienteModelRequest.getTipoCliente().equalsIgnoreCase(TipoClienteEnum.EMPRESA.getTipoCliente())){
            validaCamposEmpresa(dadosClienteModelRequest);
        } else{
            validaCamposPessoa(dadosClienteModelRequest);
        }
    }

    private void validaCamposPessoa(DadosClienteModelRequest dadosClienteModelRequest) {
        if(validaCpf(dadosClienteModelRequest.getCpf()).equals(Boolean.FALSE)){
            throw new ParametroInvalidoException();
        }
    }

    private void validaCamposEmpresa(DadosClienteModelRequest dadosClienteModelRequest) {
        if(validaCnpj(dadosClienteModelRequest.getCnpj()).equals(Boolean.FALSE)
                || dadosClienteModelRequest.getNomeEmpresa().isEmpty()){
            throw new ParametroInvalidoException();
        }
    }

    private boolean validaSenha(String senha) {
		if (senha.matches("^(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$)$")){
			return false;
		}
		return true;
	}

	private static Boolean validaCpf(String cpf){
        // valida se o cpf é formado por uma sequencia de numeros iguais
        if (cpf.equals("00000000000") ||
                cpf.equals("11111111111") ||
                cpf.equals("22222222222") || cpf.equals("33333333333") ||
                cpf.equals("44444444444") || cpf.equals("55555555555") ||
                cpf.equals("66666666666") || cpf.equals("77777777777") ||
                cpf.equals("88888888888") || cpf.equals("99999999999") ||
                (cpf.length() != 11)){
            return false;
        }
        char digito10, digito11;
        int soma, indice, resto, numero, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            soma = 0;
            peso = 10;
            for (indice=0; indice<9; indice++) {
                // converte o i-esimo caractere do CPF em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posicao de '0' na tabela ASCII)
                numero = (int)(cpf.charAt(indice) - 48);
                soma = soma + (numero * peso);
                peso = peso - 1;
            }

            resto = 11 - (soma % 11);
            if ((resto == 10) || (resto == 11))
                digito10 = '0';
            else digito10 = (char)(resto + 48); // converte no respectivo caractere numerico

            // Calculo do 2o. Digito Verificador
            soma = 0;
            peso = 11;
            for(indice=0; indice<10; indice++) {
                numero = (int)(cpf.charAt(indice) - 48);
                soma = soma + (numero * peso);
                peso = peso - 1;
            }

            resto = 11 - (soma % 11);
            if ((resto == 10) || (resto == 11)){
                digito11 = '0';
            } else {
                digito11 = (char)(resto + 48);
            }

            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((digito10 == cpf.charAt(9)) && (digito11 == cpf.charAt(10))){
                return true;
            } else{
                return false;
            }
        } catch (InputMismatchException inputMismatchException) {
            return false;
        }
    }

    public static Boolean validaCnpj(String cnpj) {
        // considera-se erro CNPJ's formados por uma sequencia de numeros iguais
        if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111") ||
                cnpj.equals("22222222222222") || cnpj.equals("33333333333333") ||
                cnpj.equals("44444444444444") || cnpj.equals("55555555555555") ||
                cnpj.equals("66666666666666") || cnpj.equals("77777777777777") ||
                cnpj.equals("88888888888888") || cnpj.equals("99999999999999") ||
                (cnpj.length() != 14))
            return(false);

        char digito13, digito14;
        int soma, indice, resto, numero, peso;

        // "try" - protege o código para eventuais erros de conversao de tipo (int)
        try {
        // Calculo do 1o. Digito Verificador
            soma = 0;
            peso = 2;
            for (indice=11; indice>=0; indice--) {
        // converte o i-ésimo caractere do CNPJ em um número:
        // por exemplo, transforma o caractere '0' no inteiro 0
        // (48 eh a posição de '0' na tabela ASCII)
                numero = (int)(cnpj.charAt(indice) - 48);
                soma = soma + (numero * peso);
                peso = peso + 1;
                if (peso == 10) {
                    peso = 2;
                }
            }

            resto = soma % 11;
            if ((resto == 0) || (resto == 1)){
                digito13 = '0';
            }else {
                digito13 = (char)((11-resto) + 48);
            }

        // Calculo do 2o. Digito Verificador
            soma = 0;
            peso = 2;
            for (indice=12; indice>=0; indice--) {
                numero = (int)(cnpj.charAt(indice)- 48);
                soma = soma + (numero * peso);
                peso = peso + 1;
                if (peso == 10)
                    peso = 2;
            }

            resto = soma % 11;
            if ((resto == 0) || (resto == 1)) {
                digito14 = '0';
            }else {
                digito14 = (char)((11-resto) + 48);
            }

        // Verifica se os dígitos calculados conferem com os dígitos informados.
            if ((digito13 == cnpj.charAt(12)) && (digito14 == cnpj.charAt(13))){
                return true;
            } else{
                return false;
            }
        } catch (InputMismatchException inputMismatchException) {
            return false;
        }
    }
}
