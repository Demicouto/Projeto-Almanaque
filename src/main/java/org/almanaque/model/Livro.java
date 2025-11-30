package org.almanaque.model;

public class Livro {
    private String isbn;
    private String titulo;
    private String autor;
    private int ano;
    private int quantidadeTotal;
    private int quantidadeDisponivel;
    private Categoria categoria;

    public Livro() {}

    // Construtor atualizado
    public Livro(String titulo, String autor, int ano, String isbn, int quantidadeTotal, Categoria categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.isbn = isbn;
        this.quantidadeTotal = quantidadeTotal;
        this.quantidadeDisponivel = quantidadeTotal;
        this.categoria = categoria;
    }

    // Getters e Setters para a Categoria
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    // ... Mantenha os outros getters e setters existentes ...

    public void setAno(int ano) { this.ano = ano; }
    public void setAutor(String autor) { this.autor = autor; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public void setQuantidadeDisponivel(int quantidadeDisponivel) { this.quantidadeDisponivel = quantidadeDisponivel; }
    public void setQuantidadeTotal(int quantidadeTotal) { this.quantidadeTotal = quantidadeTotal; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public int getAno() { return ano; }
    public String getAutor() { return autor; }
    public String getIsbn() { return isbn; }
    public int getQuantidadeDisponivel() { return quantidadeDisponivel; }
    public int getQuantidadeTotal() { return quantidadeTotal; }
    public String getTitulo() { return titulo; }

    @Override
    public String toString() {
        // Incluindo a categoria na impressão
        String nomeCategoria = (categoria != null) ? categoria.getNome() : "Sem Categoria";
        return " | Título: '" + titulo + "' | Autor: '" + autor + "' | Categoria: " + nomeCategoria + " | Disponíveis: " + quantidadeDisponivel;
    }
}