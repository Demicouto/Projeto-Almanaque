package org.almanaque.controller;

import org.almanaque.model.Usuario;
import org.almanaque.model.enums.TipoUsuario;
import org.almanaque.view.MenusView;

public class UsuarioController {
    private MenusView menus;

    public UsuarioController(){
        menus = new MenusView(new Usuario(1,"Rony","rony.lima@upe.br", TipoUsuario.ADMIN,"123"));
    }

    public void cadastrarUsuario(){
        String[] dados = menus.MenuCriarUsuario();

        //Validar se o usuário já existe

        //Validar se o email é válido
        if(dados[1].equals(dados[1].toLowerCase()) && dados[1].contains("@gmail.com")){
            System.out.println("Email válido !");
        }
    }
}
