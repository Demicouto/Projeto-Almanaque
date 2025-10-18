package org.almanaque.model;

import org.almanaque.model.enums.TipoUsuario;

public class Usuario {
    private int id;
    private String nome;
    private String email;
    private TipoUsuario tipo;

    public Usuario() {
    }

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

    @Override
    public String toString() {
        return "Usuario ID: " + id + " | Nome: '" + nome + "' | Email: '" + email + "' | Tipo: " + tipo;
    }
}

