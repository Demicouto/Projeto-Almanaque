package model;

public class Livro {
    private String titulo;
    private String autor;
    private String resumo;
    private int qntDisponivel = 0;

    public Livro(String titulo, String autor, String resumo, int qntDisponivel) {
        this.titulo = titulo;
        this.autor = autor;
        this.resumo = resumo;
        this.qntDisponivel = qntDisponivel;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public int getQntDisponivel() {
        return qntDisponivel;
    }

    public void setQntDisponivel(int qntDisponivel) {
        this.qntDisponivel = qntDisponivel;
    }
}
