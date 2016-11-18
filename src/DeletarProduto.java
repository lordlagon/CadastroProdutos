
import java.util.Scanner;

import br.com.agenda.dao.ProdutoDAO;
import br.com.agenda.model.Produto;
public class DeletarProduto {
 
public static <Int> void main(String args[]){
	
	 Scanner entrada = new Scanner(System.in);
     int id;

     
     System.out.println("Digite o id do produto: ");
     id = entrada.nextInt();
     

     
     //Cria um contato e salva no banco
     Produto produto = new Produto();

     ProdutoDAO.removeById(id);
 
	System.out.println("Produto deletado com sucesso");
 

 }
}