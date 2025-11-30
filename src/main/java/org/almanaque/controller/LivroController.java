package org.almanaque.controller;

import org.almanaque.model.Livro;
import org.almanaque.util.DataBaseConnection;
import org.almanaque.view.MenusView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroController {
    private MenusView menus;

    public LivroController() {
        this.menus = new MenusView();
    }

    /**
     * Cadastra um novo livro na base de dados.
     * Utiliza os dados recolhidos pelo MenusView.
     */
    public void cadastrarLivros() {
        String[] dados = menus.menuCadastroLivro();

        if (dados == null) {
            return;
        }

        String titulo = dados[0];
        String autor = dados[1];
        int ano = Integer.parseInt(dados[2]);
        int qntd = Integer.parseInt(dados[3]);
        String isbn = dados[4];

        String sql = "INSERT INTO livros (isbn, titulo, autor, ano, qnt_Total, qnt_Disponivel) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, isbn);
            pstmt.setString(2, titulo);
            pstmt.setString(3, autor);
            pstmt.setInt(4, ano);
            pstmt.setInt(5, qntd);
            pstmt.setInt(6, qntd); // Inicialmente, a quantidade disponível é igual à total

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("[Sucesso]: Livro '" + titulo + "' cadastrado com sucesso!");
            } else {
                System.out.println("[Erro]: Falha ao cadastrar o livro.");
            }

        } catch (SQLException e) {
            if (e.getSQLState().equals("23505")) { // Código de erro para violação de chave única (ISBN duplicado)
                System.out.println("[Erro]: O ISBN '" + isbn + "' já está cadastrado.");
            } else {
                System.out.println("[Erro de Base de Dados]: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
    public void listarLivros() {
        String sql = "SELECT l.*, c.nome as nome_categoria FROM livros l LEFT JOIN categorias c ON l.categoria_id = c.id ORDER BY l.titulo";

        System.out.println("====== LISTA DE LIVROS ======");
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            boolean encontrou = false;
            while (rs.next()) {
                encontrou = true;
                exibirLivro(rs);
            }

            if (!encontrou) {
                System.out.println("Nenhum livro cadastrado.");
            }

        } catch (SQLException e) {
            System.out.println("[Erro]: Falha ao buscar livros.");
            e.printStackTrace();
        }
    }

    public void pesquisarLivro() {
        String[] dadosPesquisa = menus.menuPesquisaLivros();

        if (dadosPesquisa[0].equals("0")) return;

        int opc = Integer.parseInt(dadosPesquisa[0]);
        String query = dadosPesquisa[1];
        String sql = "";

        switch (opc) {
            case 1:
                sql = "SELECT l.*, c.nome as nome_categoria FROM livros l LEFT JOIN categorias c ON l.categoria_id = c.id WHERE LOWER(l.titulo) LIKE LOWER(?)";
                break;
            case 2:
                sql = "SELECT l.*, c.nome as nome_categoria FROM livros l LEFT JOIN categorias c ON l.categoria_id = c.id WHERE LOWER(l.autor) LIKE LOWER(?)";
                break;
            case 3:
                sql = "SELECT l.*, c.nome as nome_categoria FROM livros l LEFT JOIN categorias c ON l.categoria_id = c.id WHERE l.ano = ?";
                break;
            default:
                System.out.println("Opção inválida.");
                return;
        }

        System.out.println("====== RESULTADOS DA PESQUISA ======");
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            if (opc == 3) {
                try {
                    pstmt.setInt(1, Integer.parseInt(query));
                } catch (NumberFormatException e) {
                    System.out.println("[Erro]: Ano inválido.");
                    return;
                }
            } else {
                pstmt.setString(1, "%" + query + "%");
            }

            try (ResultSet rs = pstmt.executeQuery()) {
                boolean encontrou = false;
                while (rs.next()) {
                    encontrou = true;
                    exibirLivro(rs);
                }
                if (!encontrou) {
                    System.out.println("Nenhum livro encontrado para a pesquisa: " + query);
                }
            }

        } catch (SQLException e) {
            System.out.println("[Erro]: Falha ao pesquisar livros.");
            e.printStackTrace();
        }
    }

    private void exibirLivro(ResultSet rs) throws SQLException {
        String titulo = rs.getString("titulo");
        String autor = rs.getString("autor");
        String isbn = rs.getString("isbn");
        int ano = rs.getInt("ano");
        int qntDisponivel = rs.getInt("qnt_Disponivel");

        // Criação do objeto apenas para exibição ou impressão direta
        System.out.println("ISBN: " + isbn + " | Título: " + titulo + " | Autor: " + autor +
                "| ano: " + ano + "| Unidades Disponíveis:" + qntDisponivel);
    }
}
