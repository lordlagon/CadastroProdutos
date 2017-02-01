
import java.util.Scanner;

import br.com.agenda.dao.ProdutoDAO;
import br.com.agenda.model.Produto;
public class CadastrarProduto {
 
public static void main(String args[]){
	
	 Scanner entrada = new Scanner(System.in);
     String nome;

     int IDfornecedor;
     int IDcategoria;
      String quantidade;
     String precounitario;
      int unidadeestoque;
      int unidadeordem;
     int niveldereposicao;
      String descontinuado;
      
      System.out.println("Digite o nome: ");
      nome = entrada.next();
      
      
     System.out.println("Digite o IDfornecedor: ");
     IDfornecedor = entrada.nextInt();
     
     System.out.println("Digite o IDcategoria: ");
     IDcategoria = entrada.nextInt();
     
     System.out.println("Digite quantidade estoque: ");
     quantidade = entrada.next();
     
     System.out.println("Digite o preco: ");
     precounitario = entrada.next();
     
     System.out.println("Digite o unidadeestoque: ");
     unidadeestoque = entrada.nextInt();
     System.out.println("Digite o unidadeordem: ");
     unidadeordem = entrada.nextInt();
     System.out.println("Digite o niveldereposicao: ");
     niveldereposicao = entrada.nextInt();
     

     System.out.println("Descontinuado T(true) ou F(false): ");
     descontinuado = entrada.next();
     
     
     //Cria um contato e salva no banco
     Produto produto = new Produto();

     produto.setNome(nome);
     produto.setIDfornecedor(IDfornecedor);
     produto.setIDcategoria(IDcategoria);
     produto.setQuantidade(quantidade);
     produto.setPrecounitario(precounitario);
     produto.setUnidadeestoque(unidadeestoque);
     produto.setUnidadeordem(unidadeordem);
     produto.setNiveldereposicao(niveldereposicao);
     produto.setDescontinuado(descontinuado);
     
     
    



     //nome,IDfornecedor,IDcategoria,quantidade,precounitario,unidadeestoque,unidadeordem,niveldereposicao,descontinuado
      
     ProdutoDAO.save(produto);
 
	System.out.println("Produto cadastrado com sucesso");
 

 }
}