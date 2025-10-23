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
        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sqlUsuario);
            System.out.println("Tabela 'usuario' criada ou já existe!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
