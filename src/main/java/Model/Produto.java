package Model;

/**
 *
 * @author Helena Amaro
 */
public class Produto {
    
    private int id;
    private String nome;
    private double preco;
    
    // Contrutor  vazio
    public Produto() {
    }

    //Contrutor
    public Produto(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }
    
    // Método get e set

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    @Override
    public String toString(){
        return "id: " +
        id + "\nNome: " + nome + 
                "\nPreco: R$ " + preco;
        
                
                
    
    
   
    }
}
   

