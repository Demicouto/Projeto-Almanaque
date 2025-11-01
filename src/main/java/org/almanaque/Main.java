package org.almanaque;

import org.almanaque.controller.UsuarioController;
import org.almanaque.model.Usuario;
import org.almanaque.model.enums.TipoUsuario;
import org.almanaque.view.MenusView;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UsuarioController usercontroller = new UsuarioController();

        Usuario user = usercontroller.cadastrarUsuario();

        MenusView menus = new MenusView(user);

        int opc = menus.MenuPrincipal();

        switch (user.getTipo()){
            case TipoUsuario.ADMIN:
                switch (opc){
                    case 1:
                        System.out.println("=Todos Livros=");
                        System.out.println("");
                        System.out.println("==============");
                        break;
                    case 2:
                        System.out.println("=Cadastrar Livros=");
                        System.out.println("");
                        System.out.println("==================");
                        break;
                    case 3:
                        System.out.println("=Multas=");
                        System.out.println("");
                        System.out.println("=========");
                        break;
                    case 4:
                        System.out.println("=Realizar empréstimo=");
                        System.out.println("");
                        System.out.println("=====================");
                        break;
                    default:
                        System.out.println("Opção inválida");
                }
                break;
            case TipoUsuario.LEITOR:
                switch (opc){
                    case 1:
                        System.out.println("=Livros recomendados=");
                        System.out.println("");
                        System.out.println("=====================");
                        break;
                    case 2:
                        System.out.println("=Pesquisar Livros=");
                        System.out.println("");
                        System.out.println("==================");
                        break;
                    case 3:
                        System.out.println("=Suas multas "+user.getNome()+"=");
                        System.out.println(0);
                        break;
                    case 4:
                        System.out.println("=Livros para devolução=");
                        System.out.println("");
                        System.out.println("=====================");
                        break;
                    default:
                        System.out.println("Opção inválida");
                }
                break;
            default:
                System.out.println("Opção inválida!");
        }

    }
}