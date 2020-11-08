package com.projeto.faculdade.ColetaProjetos.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(SnakeCaseStrategy.class)
@JsonInclude(Include.NON_EMPTY)
public class ClienteModelRequest {

	@JsonProperty("nomeCliente")
    private String nomeCliente = null;
	
	@JsonProperty("email")
    private String email = null;
	
	@JsonProperty("senha")
    private String senha = null;
	
	@JsonProperty("razaoSocial")
    private Boolean razaoSocial = null;
	
	@JsonProperty("pessoaFisica")
    private Boolean pessoaFisica = null;
	
	@JsonProperty("cpf")
    private String cpf = null;
	
	@JsonProperty("cnpj")
    private String cnpj = null;
	
	@JsonProperty("nomeEmpresa")
    private String nomeEmpresa = null;

    public String getNome() {
        return nomeCliente;
    }

    public void setNome(String nome) {
        this.nomeCliente = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(Boolean razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public Boolean getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(Boolean pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }
}
