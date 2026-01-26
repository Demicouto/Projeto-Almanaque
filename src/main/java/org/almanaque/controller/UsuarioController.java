package org.almanaque.controller;

import org.almanaque.model.Usuario;
import org.almanaque.model.enums.TipoUsuario;
import org.almanaque.util.DataBaseConnection;
import org.almanaque.view.MenusView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsuarioController {
    private MenusView menus;

    public UsuarioController(){

        menus = new MenusView();
    }

    public void cadastrarUsuario(){
        String[] dados = menus.MenuCriarUsuario();

        if (dados == null) {
            System.out.println("Cadastro cancelado pelo utilizador.");
            return;
        }

        String nome = dados[0];
        String email = dados[1];
        String senha = dados[2];

        if(!validarEmail(email)){
            System.out.println("Email inválido! O email deve conter '@'.");
            return;
        }
        if (email.contains("@gmail.com") || email.contains("@hotmail.com") || email.contains("@outlook.com")){
            Usuario novoUsuario = new Usuario(email, nome, TipoUsuario.LEITOR);
            novoUsuario.setSenha(senha);
            salvarUsuario(novoUsuario);
        }
        else if (email.contains("upe.br")){
            Usuario novoUsuario = new Usuario(email, nome, TipoUsuario.ADMIN);
            novoUsuario.setSenha(senha);
            salvarUsuario(novoUsuario);
        }
    }

    public Usuario loginUsuario() {
        String[] dadosLogin = menus.MenuLogin();

        if (dadosLogin == null) return null;

        String email = dadosLogin[0];
        String senha = dadosLogin[1];

        String sql = "SELECT * FROM usuarios WHERE email = ? AND senha = ?";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            pstmt.setString(2, senha);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String tipoString = rs.getString("tipo");

                TipoUsuario tipo = TipoUsuario.valueOf(tipoString);

                return new Usuario(id, nome, email, tipo, senha);
            } else {
                System.out.println("Email ou senha incorretos.");
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao realizar login: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }


    private boolean validarEmail(String email) {
        return email.contains("@");
    }

    private void salvarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nome, email, senha, tipo) VALUES (?, ?, ?, ?)";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, usuario.getNome());
            pstmt.setString(2, usuario.getEmail());
            pstmt.setString(3, usuario.getSenha());
            pstmt.setString(4, usuario.getTipo().name());

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("[Banco de Dados]: Usuário persistido no banco de dados com sucesso!");
            } else {
                System.out.println("[Banco de Dados]: Falha ao persistir o usuário.");
            }

        } catch (SQLException e) {
            if (e.getSQLState().equals("23505")) {
                System.out.println("[Banco de Dados]: Erro: O email '" + usuario.getEmail() + "' já está cadastrado.");
            } else {
                System.out.println("[Banco de Dados]: Erro ao salvar usuário:");
                e.printStackTrace();
            }
        }
    }
}