package org.almanaque.controller;

import org.almanaque.model.Usuario;
import org.almanaque.model.enums.TipoUsuario;
import org.almanaque.util.DataBaseConnection;
import org.almanaque.view.MenusView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioController {
    private MenusView menus;

    public UsuarioController() {
        menus = new MenusView();
    } 

    private boolean validarEmail(String email) {
        return email.contains("@");
    }


    public Usuario cadastrarUsuario() {
        String slq = "INSERT INTO usuarios (nome, email, senha, tipo) VALUES (?,?,?,?)";

        try {
            Connection conn = DataBaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(slq);

            String[] dados = menus.MenuCriarUsuario(); // Retorna [nome, email, senha] ou null

            String nome = dados[0];
            String email = dados[1];
            String senha = dados[2];
            TipoUsuario tipo;

            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, senha);
            if(email.contains("@upe.br")){//Email da upe vira adm caso contrario leito qualquer
                tipo = TipoUsuario.ADMIN;
            }else{
                tipo = TipoUsuario.LEITOR;
            }

            stmt.setString(4, String.valueOf(tipo));

            stmt.executeUpdate();
            System.out.println("Usuário criado com sucesso!");

            if (!validarEmail(email)) {
                System.out.println("Email inválido! O email deve conter '@'.");
                return null;
            }

            return new Usuario(nome, email, senha, tipo);

        }catch (SQLException e){
            System.out.println(e);
        }
        return null;
    }
}