package org.almanaque.controller;

import org.almanaque.model.Livro;
import org.almanaque.view.MenusView;

import java.util.ArrayList;

public class LivroController {
    MenusView menus;
    ArrayList<Livro> livros = new ArrayList<>();

    public LivroController(){
        menus = new MenusView();
    }

    public void cadastrarLivros(){
        String[] dados = menus.menuCadastroLivro();

        String titulo = dados[0];
        String autor = dados[1];
        int ano = Integer.parseInt(dados[2]);
        int qntd = Integer.parseInt(dados[3]);
        String isbn = dados[4];

        Livro livro = new Livro(titulo, autor, ano, isbn, qntd);

        livros.add(livro);
        System.out.println("Livro cadastrado !");

        //por no banco de dados
    }

    public void pegarLivrosCadastrados(){
        for(Livro l: livros){
            System.out.println(l);
        }
    }

    public void todasMultas(){
        System.out.println("Ainda não tem multas");
    }

    public void solicitacoesEmprestimo(){
        System.out.println("Ainda não há solicitações de empréstimo");
    }

    public void mostrarRecomendados(){
        System.out.println("Ainda não há recomendados");
    }

    public void pesquisarLivro(){
        ArrayList<Livro> livrosEncontrados = new ArrayList<>();
        String[] opc = menus.menuPesquisaLivros();

        switch (Integer.parseInt(opc[0])){
            case 1:
                for(Livro l: livros){
                    if(l.getTitulo().contains(opc[1])){
                        livrosEncontrados.add(l);
                    }
                }
                break;
            case 2:
                for(Livro l: livros){
                    if(l.getAutor().contains(opc[1])){
                        livrosEncontrados.add(l);
                    }
                }
                break;
            case 3:
                for(Livro l: livros){
                    if(l.getAno() ==  Integer.parseInt(opc[1])){
                        livrosEncontrados.add(l);
                    }
                }
                break;
            default:
                System.out.println("Opção inválida !");
        }

        System.out.println("Quantidade de livros encontrados: "+livros.size());

        for(Livro l:livrosEncontrados){
            System.out.println(l);
        }
    }
}
