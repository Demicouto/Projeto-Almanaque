package org.almanaque.controller;

import org.almanaque.model.Usuario;
import org.almanaque.model.enums.TipoUsuario;
import org.almanaque.util.DataBaseConnection;
import org.almanaque.view.MenusView;

import java.io.*;
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
        //String slq = "INSERT INTO usuarios (nome, email, senha, tipo) VALUES (?,?,?,?)";

        try {
            BufferedWriter arquivo = new BufferedWriter(new FileWriter("C:\\Users\\Rony\\Desktop\\Projeto-Almanaque\\docs\\data\\user\\userLog.txt"));

            //Connection conn = DataBaseConnection.getConnection();
            //PreparedStatement stmt = conn.prepareStatement(slq);

            String[] dados = menus.MenuCriarUsuario(); // Retorna [nome, email, senha] ou null

            String nome = dados[0];
            String email = dados[1];
            String senha = dados[2];
            TipoUsuario tipo;

            //stmt.setString(1, nome);
            arquivo.write(nome);
            arquivo.newLine();
            //stmt.setString(2, email);
            arquivo.write(email);
            arquivo.newLine();
            //stmt.setString(3, senha);
            arquivo.write(senha);
            arquivo.newLine();
            if(email.contains("@upe.br")){//Email da upe vira adm caso contrario leito qualquer
                tipo = TipoUsuario.ADMIN;
            }else{
                tipo = TipoUsuario.LEITOR;
            }

            //stmt.setString(4, String.valueOf(tipo));
            arquivo.write(tipo.toString());

            //stmt.executeUpdate();
            arquivo.close();
            System.out.println("Usuário criado com sucesso!");

            if (!validarEmail(email)) {
                System.out.println("Email inválido! O email deve conter '@'.");
                return null;
            }

            return new Usuario(nome, email, senha, tipo);

        }catch (IOException e){
            System.out.println(e);
        }
        return null;
    }

    public void loginUsuario(){
        String[] dados = menus.MenuLogin();

        //pegar infos do banco de dados
    }

    public Usuario validarUsuarioLogado(){
        //Pegar no Log quem foi o ultimo logado;
        try{
            BufferedReader arquivo = new BufferedReader(new FileReader("C:\\Users\\Rony\\Desktop\\Projeto-Almanaque\\docs\\data\\user\\userLog.txt"));

            //Valida email do txt e vê se bate com o do banco
            //valida nome, senha e email do txt com os do banco

            String nome = arquivo.readLine();
            String email = arquivo.readLine();
            String senha = arquivo.readLine();
            TipoUsuario tipo = TipoUsuario.valueOf(arquivo.readLine());

            return new Usuario(email,nome, senha, tipo);

        }catch (IOException e){
            System.out.println(e);
        }
        return null;
    }
}