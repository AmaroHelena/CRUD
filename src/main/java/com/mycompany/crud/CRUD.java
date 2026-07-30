
package com.mycompany.crud;

import java.util.Scanner;
import Dao.ProjetoDao;
import Model.Produto;

/**
 *
 * @author Helena Amaro
 */
public class CRUD {
    
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        
        ProjetoDao dao = new ProjetoDao();
        
        int opcao;
         do{

            System.out.println("\n====== CRUD DE PRODUTOS ======");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Buscar");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Excluir");
            System.out.println("0 - Sair");

            opcao = sc.nextInt();

            switch(opcao){

                case 1:

                    System.out.print("ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Preço: ");
                    double preco = sc.nextDouble();

                    dao.adicionar(new Produto(id,nome,preco));

                    System.out.println("Produto cadastrado!");

                    break;

                case 2:

                    dao.listar();

                    break;

                case 3:

                    System.out.print("Digite o ID: ");

                    Produto p = dao.buscar(sc.nextInt());

                    if(p!=null)
                        System.out.println(p);
                    else
                        System.out.println("Produto não encontrado.");

                    break;

                case 4:

                    System.out.print("ID do produto: ");
                    id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Novo nome: ");
                    nome = sc.nextLine();

                    System.out.print("Novo preço: ");
                    preco = sc.nextDouble();

                    if(dao.atualizar(id,nome,preco))
                        System.out.println("Atualizado com sucesso.");
                    else
                        System.out.println("Produto não encontrado.");

                    break;

                case 5:

                    System.out.print("ID do produto: ");

                    if(dao.excluir(sc.nextInt()))
                        System.out.println("Produto removido.");
                    else
                        System.out.println("Produto não encontrado.");

                    break;

                case 0:

                    System.out.println("Sistema encerrado.");

                    break;

                default:

                    System.out.println("Opção inválida.");

            }

        }while(opcao!=0);

        sc.close();

    }

}
