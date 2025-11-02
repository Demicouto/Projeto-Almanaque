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
        MenusView menus = new MenusView();

        while(true) {

            Usuario usuarioLogado = null;
            int opcLogin = -1;

            do {
                opcLogin = menus.menuBoasVindas();

                switch (opcLogin) {
                    case 1:
                        usuarioLogado = usercontroller.validarUsuarioLogado();
                        if (usuarioLogado == null) {
                            System.out.println("Nenhum usuário encontrado. Por favor, crie uma conta.");
                        } else {
                            System.out.println("Login automático bem-sucedido!");
                        }
                        break;
                    case 2:
                        usuarioLogado = usercontroller.cadastrarUsuario();
                        break;
                    case 0:
                        System.out.println("Saindo do sistema... Obrigado por usar o Almanaque!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } while (usuarioLogado == null);

            menus.setUsuarioLogado(usuarioLogado);

            LivroController livroController = new LivroController();

            int opc = -1;
            do {
                // vai mostrar o MenuPrincipal (Admin ou Leitor)
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
                            case 5:
                                System.out.println("=Pesquisar Livros=");
                                livroController.pesquisarLivro();
                                System.out.println("==================");
                                break;
                            case 6:
                                System.out.println("=Pesquisar Livros=");
                                livroController.pesquisarLivro();
                                System.out.println("==================");
                            case 0:
                                System.out.println("Logout...");
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
                                System.out.println("Implementação possivel apenas com a persistencia no banco de dados...");

                                break;
                            case 4:
                                System.out.println("=Livros para devolução=");
                                System.out.println("Sistema e desenvolvimento !");
                                System.out.println("=====================");
                                break;
                            case 0:
                                System.out.println("Logout...");
                                break;
                            default:
                                System.out.println("Opção inválida");
                        }
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } while (opc != 0);
        }
    }
}