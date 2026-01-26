package org.almanaque.model;

import org.almanaque.model.enums.TipoUsuario;

public class Usuario {
    private int id;
    private String nome;
    private String email;
    private TipoUsuario tipo;
    private String senha;



     // Usaremos este construtor para carregar um usuário do banco de dados.
    public Usuario(int id, String nome, String email, TipoUsuario tipo, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.tipo = tipo;
        this.senha = senha;
    }

     //construtor para criar o usuario, no banco ele receberá um id
    public Usuario(String email, String nome, TipoUsuario tipo) {
        this.email = email;
        this.nome = nome;
        this.tipo = tipo;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", tipo=" + tipo +
                ", senha='" + senha + '\'' +
                '}';
    }
}