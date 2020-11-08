package com.projeto.faculdade.ColetaProjetos.model;

//Aqui criamos as classes que são salvas no banco, as @Entity, e @Table

public class ClienteModel {

    private String name;
    private String email;
    private String password;
    private Boolean socialReason;
    private Boolean physicalPerson;
    private String cpf;
    private String cnpj;
    private String companyName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getSocialReason() {
        return socialReason;
    }

    public void setSocialReason(Boolean socialReason) {
        this.socialReason = socialReason;
    }

    public Boolean getPhysicalPerson() {
        return physicalPerson;
    }

    public void setPhysicalPerson(Boolean physicalPerson) {
        this.physicalPerson = physicalPerson;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
