package com.example.reciclasanja;

class ClienteModel {
    private String idUsuario;
    private String nome;
    private String telefone;
    private String email;
    private String senha;
    private String senha_antiga;



    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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

    public String getSenha_antiga() {
        return senha_antiga;
    }

    public void setSenha_antiga(String senha_antiga) {
        this.senha_antiga = senha_antiga;
    }

    }

