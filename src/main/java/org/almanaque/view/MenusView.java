package org.almanaque.view;

import org.almanaque.model.Usuario;
import org.almanaque.model.enums.TipoUsuario;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class MenusView {
    private Usuario usuarioLogado;
    private Scanner sc;

    public MenusView(){
        this.sc = new Scanner(System.in);
    }

    public MenusView(Usuario usuarioLogado){
        this.sc = new Scanner(System.in);
        this.usuarioLogado  = usuarioLogado;
    }

    public int MenuPrincipal(){
        int opc = -1;

        do {
            System.out.println("======================");

            switch (usuarioLogado.getTipo()){
                case TipoUsuario.LEITOR:
                    System.out.println("[1]-Mostrar livros recomendados");
                    System.out.println("[2]-Pesquisar Livros");
                    System.out.println("[3]-Multas/Atraso");
                    System.out.println("[4]-Devolver Livro");
                    break;

                case TipoUsuario.ADMIN:
                    System.out.println("[1]-Mostrar todos os livros");
                    System.out.println("[2]-Cadastrar livro");
                    System.out.println("[3]-Multas");
                    System.out.println("[4]-Realizar Empréstimo");
                    break;

                default:
                    System.out.println("Nenhuma opção disponível!");
            }

            System.out.println("======================");

            System.out.println("[0]-Sair");
            System.out.print("Escolha uma opção:");
            opc = sc.nextInt();
            sc.nextLine();//Limpar o scanner
            return opc;
        }while(opc !=0);
    }

    public String[] MenuLogin(){
        int opc =-1;

        do{
            System.out.println("=======================");
            System.out.println("[*]: Email do usuário");
            System.out.println("[*]: Senha do usuário");
            System.out.println("=======================");

            System.out.print("[Email]:");
            String email = sc.nextLine();
            System.out.print("[Senha]:");
            String senha = sc.nextLine();

            //tratar os dados

            String[] usuarioNaoValidado = {email, senha};
            return usuarioNaoValidado;

        }while (opc!=0);
    }

    public String[] MenuCriarUsuario() {
        int opc = -1;

        do {
            System.out.println("=======================");
            System.out.println("[1]: Nome");
            System.out.println("[2]: Email");
            System.out.println("[3]: Senha");
            System.out.println("=======================");
            System.out.println();

            System.out.print("[Nome]:");
            String nome = sc.nextLine();
            System.out.print("[Email]:");
            String email = sc.nextLine();
            System.out.print("[Senha]:");
            String senha = sc.nextLine();
            System.out.print("Deseja salvar o usuario: " + nome + " (s/n): ");
            String confirmacao = sc.nextLine().toLowerCase();

            if (confirmacao.equals("s")) {
                String[] usuarioNaoValidado = {nome, email, senha};
                return usuarioNaoValidado;
            }
                else{
                    System.out.println("Cadastro cancelado. Tentar novamente? (s/n)");
                    confirmacao = sc.nextLine().toLowerCase();

                    if (confirmacao.equals("n")) {
                        opc = 0;
                    }
                }
            } while (opc != 0) ;
            return null;
        }

    public String[] menuCadastroLivro(){
        int opc = -1;

        do{
            System.out.println("=======================");
            System.out.println("[1]: Titulo");
            System.out.println("[2]: Autor");
            System.out.println("[3]: ano");
            System.out.println("[4]: quantidade");
            System.out.println("=======================");
            System.out.println();

            System.out.print("[Titulo]:");
            String titulo = sc.nextLine(); //ISBN do livro
            System.out.print("[ISBN]:");
            String isbn = sc.nextLine();
            System.out.print("[Autor]:");
            String autor = sc.nextLine();
            System.out.print("[Ano]:");
            String ano = sc.nextLine();
            System.out.print("[Quantidade]:");
            String qntd = sc.nextLine();

            System.out.print("Deseja salvar o livro: " + titulo + " (s/n): ");
            String confirmacao = sc.nextLine().toLowerCase();

            if (confirmacao.equals("s")) {
                String[] livroNaoValidado = {titulo, autor, ano, qntd, isbn};
                return livroNaoValidado;
            }
            else{
                System.out.println("Cadastro cancelado. Tentar novamente? (s/n)");
                confirmacao = sc.nextLine().toLowerCase();

                if (confirmacao.equals("n")) {
                    opc = 0;
                }
            }
        }while(opc!=0);
        return null;
    }

    public String[] menuPesquisaLivros(){
        int opc =-1;
        do{
            System.out.println("=======================");
            System.out.println("[1]: Titulo");
            System.out.println("[2]: Autor");
            System.out.println("[3]: Ano");
            System.out.println("=======================");
            System.out.println();
            System.out.println("[0]-Sair");
            System.out.print("Pesquisar por qual parâmetro: ");
            String opc2 = sc.nextLine();

            String query = "";
            switch (Integer.parseInt(opc2)){
                case 1:
                    System.out.print("Digite o titulo: ");
                    query = sc.nextLine();
                    break;
                case 2:
                    System.out.print("Digite o autor: ");
                    query = sc.nextLine();
                    break;
                case 3:
                    System.out.print("Digite o ano: ");
                    query = sc.nextLine();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
            String[] resultado = {opc2, query};
            return resultado;
        }while (opc!=0);
    }
}
