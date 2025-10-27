package org.almanaque.controller;

import org.almanaque.model.Usuario;
import org.almanaque.model.enums.TipoUsuario;
import org.almanaque.view.MenusView;

public class UsuarioController {
    private MenusView menus;

    public UsuarioController() {

        menus = new MenusView(new Usuario(1, "Rony", "rony.lima@upe.br", TipoUsuario.ADMIN, "123"));
    } 

    private boolean validarEmail(String email) {
        return email.contains("@");
    }

    public void cadastrarUsuario() {
        String[] dados = menus.MenuCriarUsuario(); // Retorna [nome, email, senha] ou null

        String nome = dados[0];
        String email = dados[1];
        String senha = dados[2];

        System.out.println(email + "\n" + nome + "\n" + senha + "\n");
        if (!validarEmail(email)) {
            System.out.println("Email inválido! O email deve conter '@'.");
            return;
        }
    }
}