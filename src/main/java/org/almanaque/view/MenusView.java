package org.almanaque.view;

import org.almanaque.model.Usuario;
import org.almanaque.model.enums.TipoUsuario;

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

    public void MenuPrincipal(){
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
                    System.out.println("[5]-Cadastrar Usuário");
                    break;

                default:
                    System.out.println("Nenhuma opção disponível!");
            }

            System.out.println("======================");

            System.out.println("[0]-Sair");
            System.out.print("Escolha uma opção:");
            opc = sc.nextInt();
            sc.nextLine();//Limpar o scanner

            switch (opc){
                case 1:
                    if(usuarioLogado.getTipo() == TipoUsuario.LEITOR){
                        //Mostrar livros recomendados
                    }else {
                        //Mostrar todos os livros
                    }
                    break;
                case 2:
                    if(usuarioLogado.getTipo() == TipoUsuario.LEITOR){
                        //Pesquisar livros
                    }else {
                        //Cadastrar livros
                    }
                    break;
                case 3:
                    //Multas Atraso
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

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
                        opc = 0; // Sair do loop
                    }
                    // Se for "s" ou qualquer outra coisa, o loop continua
                }
                //Validar se o usuário ja existe no banco;
                //Validar os dados e tratar
            } while (opc != 0) ;
            return null;
        }

}
