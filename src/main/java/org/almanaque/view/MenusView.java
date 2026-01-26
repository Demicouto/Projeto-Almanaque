package org.almanaque.view;

import org.almanaque.model.Usuario;
import org.almanaque.model.enums.TipoUsuario;
import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.util.InputMismatchException;

import java.util.Scanner;

public class MenusView {
    private Usuario usuarioLogado;
    private Scanner sc;
    private static final int ANO_MINIMO = 1000;


    public MenusView(){
        this.sc = new Scanner(System.in);
    }

    public MenusView(Usuario usuarioLogado){
        this.sc = new Scanner(System.in);
        this.usuarioLogado  = usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }


    private int lerInteiro() {
        while (true) {
            try {
                int opc = sc.nextInt();
                sc.nextLine();
                return opc;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Por favor, digite apenas números.");
                System.out.print("Tente novamente: ");
                sc.nextLine();
            }
        }
    }

    private int lerAnoValido() {
        int anoAtual = LocalDate.now().getYear(); // Pega o ano atual (ex: 2025)

        while (true) {
            int ano = lerInteiro();

            if (ano >= ANO_MINIMO && ano <= anoAtual) {
                return ano;
            } else {
                System.out.println("Erro: O ano deve ser válido (entre " + ANO_MINIMO + " e " + anoAtual + ").");
                System.out.print("Tente novamente: ");
            }
        }
    }




    public int MenuPrincipal(){
        int opc = -1;

        do {
            System.out.println("======================");

            switch (usuarioLogado.getTipo()){
                case TipoUsuario.LEITOR:
                    System.out.println("[1]-Mostrar livros recomendados - em desenvolvimento");
                    System.out.println("[2]-Pesquisar Livros");
                    System.out.println("[3]-Multas/Atraso - em desenvolvimento");
                    System.out.println("[4]-Devolver Livro - em desenvolvimento");
                    break;

                case TipoUsuario.ADMIN:
                    System.out.println("[1]-Mostrar todos os livros");
                    System.out.println("[2]-Cadastrar livro");
                    System.out.println("[3]-Multas - em desenvolvimento");
                    System.out.println("[4]-Realizar Empréstimo - em desenvolvimento... ");
                    System.out.println("[5]-pesquisar livro");
                    break;

                default:
                    System.out.println("Nenhuma opção disponível!");
            }

            System.out.println("======================");

            System.out.println("[0]-Sair");
            System.out.print("Escolha uma opção:");
            opc = lerInteiro();

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
            String email = sc.nextLine().trim();
            System.out.print("[Senha]:");
            String senha = sc.nextLine().trim();


            String[] usuarioNaoValidado = {email, senha};
            return usuarioNaoValidado;

        }while (opc!=0);
    }

    public int menuBoasVindas() {
        System.out.println("======================");
        System.out.println("  BEM-VINDO AO ALMANAQUE ");
        System.out.println("======================");
        System.out.println("[1] - Fazer Login");
        System.out.println("[2] - Criar Conta");
        System.out.println("[0] - Sair do Sistema"); // Esta é a saída REAL
        System.out.println("======================");
        System.out.print("Escolha uma opção: ");

        return lerInteiro();
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

        System.out.println("=======================");
        System.out.println("[1]: Titulo");
        System.out.println("[2]: Autor");
        System.out.println("[3]: ano");
        System.out.println("[4]: quantidade");
        System.out.println("==============" +
                "=========");
        System.out.println();
        do{


            System.out.print("[Titulo]:");
            String titulo = sc.nextLine();
            System.out.print("[ISBN]:");
            String isbn = sc.nextLine();
            System.out.print("[Autor]:");
            String autor = sc.nextLine();
            System.out.print("[Ano]:");
            int opcAno = lerAnoValido();
            System.out.print("[Quantidade]:");
            int opcQntd = lerInteiro();

            System.out.print("Deseja salvar o livro: " + titulo + " (s/n): ");
            String confirmacao = sc.nextLine().toLowerCase();

            if (confirmacao.equals("s")) {
                String ano = "" + opcAno;
                String qntd = "" + opcQntd;

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
        int opc = -1;
        do{
            System.out.println("=======================");
            System.out.println("[1]: Titulo");
            System.out.println("[2]: Autor");
            System.out.println("[3]: Ano");
            System.out.println("=======================");
            System.out.println();
            System.out.println("[0]-Sair");
            System.out.print("Pesquisar por qual parâmetro: ");
            int opc2 = lerInteiro();

            String query = "";
            switch (opc2){
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
            String[] resultado = {"" + opc2, query};
            return resultado;
        }while (opc!=0);
    }
}
