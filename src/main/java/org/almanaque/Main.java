package org.almanaque;

import org.almanaque.controller.UsuarioController;
import org.almanaque.util.DataBaseConnection;
import org.almanaque.util.DatabaseSetup;

import java.sql.Connection;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
        UsuarioController teste = new UsuarioController();
        teste.cadastrarUsuario();
    }
}