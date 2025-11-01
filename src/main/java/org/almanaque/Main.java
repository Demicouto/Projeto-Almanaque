package org.almanaque;

import org.almanaque.controller.LivroController;
import org.almanaque.controller.UsuarioController;
import org.almanaque.model.Usuario;
import org.almanaque.model.enums.TipoUsuario;
import org.almanaque.view.MenusView;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        UsuarioController usercontroller = new UsuarioController();
        Usuario usuarioLogado = usercontroller.validarUsuarioLogado();

        if(usuarioLogado == null){
            usuarioLogado = usercontroller.cadastrarUsuario();
        }

        LivroController livroController = new LivroController();


        MenusView menus = new MenusView(usuarioLogado);

        int opc = -1;
        do {
            opc = menus.MenuPrincipal();

            switch (usuarioLogado.getTipo()){
                case TipoUsuario.ADMIN:
                    switch (opc){
                        case 1:
                            System.out.println("=Todos Livros=");
                            livroController.pegarLivrosCadastrados();
                            System.out.println("==============");
                            break;
                        case 2:
                            System.out.println("=Cadastrar Livros=");
                            livroController.cadastrarLivros();
                            System.out.println("==================");
                            break;
                        case 3:
                            System.out.println("=Multas=");
                            livroController.todasMultas();
                            System.out.println("=========");
                            break;
                        case 4:
                            System.out.println("=Realizar empréstimo=");
                            livroController.solicitacoesEmprestimo();
                            System.out.println("=====================");
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Opção inválida");
                    }
                    break;
                case TipoUsuario.LEITOR:
                    switch (opc){
                        case 1:
                            System.out.println("=Livros recomendados=");
                            livroController.mostrarRecomendados();
                            System.out.println("=====================");
                            break;
                        case 2:
                            System.out.println("=Pesquisar Livros=");
                            livroController.pesquisarLivro();
                            System.out.println("==================");
                            break;
                        case 3:
                            System.out.println("=Suas multas "+usuarioLogado.getNome()+"=");
                            System.out.println(0);
                            break;
                        case 4:
                            System.out.println("=Livros para devolução=");
                            System.out.println("Sistema e desenvolvimento !");
                            System.out.println("=====================");
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Opção inválida");
                    }
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }while (opc!=0);

    }
}