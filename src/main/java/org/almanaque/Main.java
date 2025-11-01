package org.almanaque;

import org.almanaque.controller.UsuarioController;
import org.almanaque.model.Usuario;
import org.almanaque.util.DataBaseConnection;
import org.almanaque.util.DatabaseSetup;
import org.almanaque.view.MenusView;

import java.sql.Connection;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
        UsuarioController teste = new UsuarioController();
        Usuario user = teste.cadastrarUsuario();
        MenusView menus = new MenusView(user);
        menus.MenuPrincipal();
    }
}