package org.almanaque.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSetup {
    public static void criarTabelas() {
        String sqlUsuario = """
            CREATE TABLE IF NOT EXISTS usuarios (
                id SERIAL PRIMARY KEY,
                nome VARCHAR(20) NOT NULL,
                email VARCHAR(100) UNIQUE NOT NULL,
                senha VARCHAR(100) NOT NULL,
                tipo VARCHAR(100) NOT NULL
            );
            """;

        String sqlCategoria = """
            CREATE TABLE IF NOT EXISTS categorias(
                id SERIAL PRIMARY KEY,
                nome VARCHAR(100) UNIQUE NOT NULL
            );
            """;

        String sqlLivro = """
            CREATE TABLE IF NOT EXISTS livros (
                isbn VARCHAR(13) PRIMARY KEY,
                titulo VARCHAR(255) NOT NULL,
                autor VARCHAR(255) NOT NULL,
                categoria_id INT REFERENCES categorias(id),
                ano INT,
                qnt_Total INT NOT NULL,
                qnt_Disponivel INT NOT NULL
            );
            """;

        String sqlEmprestimo = """
            CREATE TABLE IF NOT EXISTS emprestimos (
                id SERIAL PRIMARY KEY,
                usuarioId INT NOT NULL REFERENCES usuarios(id),
                livroIsbn VARCHAR(13) NOT NULL REFERENCES livros(isbn),
                data_Emprestimo TIMESTAMP NOT NULL,
                data_Devolucao TIMESTAMP,
                status VARCHAR(50) NOT NULL,
                multa DECIMAL(10, 2) DEFAULT 0.0
            );
            """;

        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sqlUsuario);
            System.out.println("Tabela 'usuario' criada ou já existe!");

            stmt.execute(sqlCategoria);
            System.out.println("Tabela 'categorias' criado com sucesso ou ja existente!");

            stmt.execute(sqlLivro);
            System.out.println("Tabela 'livro' criado com sucesso ou ja existente!");

            stmt.execute(sqlEmprestimo);
            System.out.println("Tabela 'emprestimos' criado com sucesso ou ja existente!");



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
