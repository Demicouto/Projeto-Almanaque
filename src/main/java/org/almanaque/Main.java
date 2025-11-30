package org.almanaque;

import org.almanaque.controller.LivroController;
import org.almanaque.controller.UsuarioController;
import org.almanaque.util.DatabaseSetup;
import org.almanaque.model.Usuario;
import org.almanaque.model.enums.TipoUsuario;
import org.almanaque.view.MenusView;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseSetup.criarTabelas();
        UsuarioController appController = new UsuarioController();
        MenusView menus = new MenusView();

        Usuario usuarioLogado = null;

        while(true) {
            while (usuarioLogado == null) {
                int opcLogin = menus.menuBoasVindas();

                switch (opcLogin) {
                    case 1:
                        usuarioLogado = appController.loginUsuario();
                        if (usuarioLogado != null) {
                            System.out.println("Bem-vindo, " + usuarioLogado.getNome() + "!");
                        }
                        break;

                    case 2:
                        appController.cadastrarUsuario();
                        break;

                    case 0:
                        System.out.println("Saindo do sistema...");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }
            }

            LivroController livroController = new LivroController();
            int opc = -1;

            menus.setUsuarioLogado(usuarioLogado);

            do {
                opc = menus.MenuPrincipal();

                switch (usuarioLogado.getTipo()){
                    case TipoUsuario.ADMIN:
                        switch (opc){
                            case 1:
                                System.out.println("Listar livros...");
                                livroController.listarLivros();
                                break;
                            case 2:
                                System.out.println("Cadastrar Livros: ");
                                livroController.cadastrarLivros();
                                break;
                            case 3:
                                System.out.println("Multas em desenvolvimento...");
                                break;
                            case 4:
                                System.out.println("Realizar empréstimo em desenvolvimento...");
                                break;
                            case 5:
                                System.out.println("Pesquisar Livros: ");
                                livroController.pesquisarLivro();
                                break;
                            case 0:
                                System.out.println("Logout...");
                                usuarioLogado = null;
                                break;
                            default:
                                System.out.println("Opção inválida");
                        }
                        break;

                    case TipoUsuario.LEITOR:
                        switch (opc){
                            case 1:
                                System.out.println("Livros recomendados em desenvolvimento...");
                                break;
                            case 2:
                                System.out.println("Pesquisar Livros: ");
                                livroController.pesquisarLivro();
                                break;
                            case 3:
                                System.out.println("=Suas multas " + usuarioLogado.getNome()+"=");
                                System.out.println("Implementação possivel apenas com a persistencia de emprestimos no banco de dados...");

                                break;
                            case 4:
                                System.out.println("Livros para devolução em desenvolvimento...");
                                break;
                            case 0:
                                System.out.println("Logout...");
                                usuarioLogado = null;
                                break;
                            default:
                                System.out.println("Opção inválida");
                        }
                        break;
                }
            } while (usuarioLogado != null && opc != 0);
        }
    }
}