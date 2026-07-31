package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Produto;

/**
 * @author Helena Amaro
 */
public class ProjetoDao {

    // Adicionar produto (Tabela: produto)
    public void adicionar(Produto produto) {
        String sql = "INSERT INTO produto (id, nome, preco) VALUES (?, ?, ?)";
        
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, produto.getId());
            stmt.setString(2, produto.getNome());
            stmt.setDouble(3, produto.getPreco());
            
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar produto: " + e.getMessage());
        }
    }

    // Listar produtos (Tabela: produto)
    public void listar() {
        String sql = "SELECT * FROM produto";
        boolean encontrou = false;
        
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                encontrou = true;
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                double preco = rs.getDouble("preco");
                
                Produto p = new Produto(id, nome, preco);
                System.out.println("--------------");
                System.out.println(p);
            }
            
            if (!encontrou) {
                System.out.println("\nNenhum produto cadastrado no banco de dados.");
            }
            
        } catch (SQLException e) {
            System.err.println("Erro ao listar produtos: " + e.getMessage());
        }
    }

    // Atualizar produto (Tabela: produto)
    public boolean atualizar(int id, String novoNome, double novoPreco) {
        String sql = "UPDATE produto SET nome = ?, preco = ? WHERE id = ?";
        
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, novoNome);
            stmt.setDouble(2, novoPreco);
            stmt.setInt(3, id);
            
            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
            
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar produto: " + e.getMessage());
            return false;
        }
    }

    // Excluir produto (Tabela: produto)
    public boolean excluir(int id) {
        String sql = "DELETE FROM produto WHERE id = ?";
        
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            
            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
            
        } catch (SQLException e) {
            System.err.println("Erro ao excluir produto: " + e.getMessage());
            return false;
        }
    }

    // Buscar produto (Tabela: produto)
    public Produto buscar(int id) {
        String sql = "SELECT * FROM produto WHERE id = ?";
        
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String nome = rs.getString("nome");
                    double preco = rs.getDouble("preco");
                    return new Produto(id, nome, preco);
                }
            }
            
        } catch (SQLException e) {
            System.err.println("Erro ao buscar produto: " + e.getMessage());
        }
        return null;
    }
}