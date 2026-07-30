package Dao;

import java.util.ArrayList;
import Model.Produto;

/**
 *
 * @author Helena Amaro
 */
public class ProjetoDao {

    private ArrayList<Produto> lista = new ArrayList<>();

    // Adicionar produto
    public void adicionar(Produto produto) {
        lista.add(produto);
    }

    // Listar produtos
    public void listar() {

        if (lista.isEmpty()) {
            System.out.println("\nNenhum produto cadastrado.");
            return;
        }

        for (Produto p : lista) {
            System.out.println("--------------");
            System.out.println(p);
        }
    }

    // Atualizar produto
    public boolean atualizar(int id, String novoNome, double novoPreco) {

        for (Produto p : lista) {

            if (p.getId() == id) {

                p.setNome(novoNome);
                p.setPreco(novoPreco);
                return true;

            }
        }
        return false;
    }

    // Excluir produto
    public boolean excluir(int id) {

        for (Produto p : lista) {

            if (p.getId() == id) {
                lista.remove(p);
                return true;
            }
        }
        return false;
    }

    // Buscar produto
    public Produto buscar(int id) {

        for (Produto p : lista) {

            if (p.getId() == id) {
                return p;
            }
        }

        return null;
    }
}
