package org.almanaque.model;

public class Categoria {
    private int id;
    private String nome;

    // Construtor vazio
    public Categoria() {
    }

    // Construtor para criação (ainda sem ID definido pelo banco)
    public Categoria(String nome) {
        this.nome = nome;
    }

    // Construtor completo (para quando buscar do banco de dados)
    public Categoria(int id, String nome) {
        this.id = id;
        this.nome = nome;
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

    @Override
    public String toString() {
        return "Categoria: " + " | id: " + id + ", | nome: " + nome;
    }
}
