
import java.util.Scanner;

import br.com.agenda.dao.CategoriaDAO;
import br.com.agenda.model.Categoria;
public class DeletarCategoria {
 
public static <Int> void main(String args[]){
	
	 Scanner entrada = new Scanner(System.in);
     int id;

     
     System.out.println("Digite o id da categoria: ");
     id = entrada.nextInt();
     

     
     //Cria um contato e salva no banco
     Categoria categoria = new Categoria();

     CategoriaDAO.removeById(id);
 
	System.out.println("Categoria deletada com sucesso");
 

 }
}