package org.almanaque.model;
import org.almanaque.model.enums.StatusEmprestimo;
import java.time.LocalDateTime;

public class Emprestimo {

    private int id;
    private int usuarioId;
    private int livroIsbn;
    private LocalDateTime dataEmprestimo;
    private LocalDateTime dataDevolucao;
    private StatusEmprestimo status;
    private double multa;

    public Emprestimo() {
    }

    public Emprestimo(int usuarioId, int livroIsbn) {
        this.usuarioId = usuarioId;
        this.livroIsbn = livroIsbn;
        this.dataEmprestimo = LocalDateTime.now();
        this.status = StatusEmprestimo.EMPRESTADO;
        this.multa = 0.0;
        this.dataDevolucao = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getLivroIsbn() {
        return livroIsbn;
    }

    public void setLivroIsbn(int livroIsbn) {
        this.livroIsbn = this.livroIsbn;
    }

    public LocalDateTime getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDateTime dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public StatusEmprestimo getStatus() {
        return status;
    }

    public void setStatus(StatusEmprestimo status) {
        this.status = status;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    @Override
    public String toString() {
        return "Empréstimo ID: " + id + " | Isbn: " + livroIsbn + " | Usuário ID: " + usuarioId + " | Status: " + status;
    }
}