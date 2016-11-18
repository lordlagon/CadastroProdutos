
import java.util.Scanner;

import br.com.agenda.dao.CategoriaDAO;
import br.com.agenda.model.Categoria;
public class UpdateCategoria {
 
public static void main(String args[]){
	
	 Scanner entrada = new Scanner(System.in);
	 int id;
     String nome;
     String descricao;
     String figura;
     
     
     System.out.println("Digite o id da categoria: ");
     id = entrada.nextInt();
     System.out.println("Digite o nome da categoria: ");
     nome = entrada.next();
     System.out.println("Digite o descrição da categoria: ");
     descricao = entrada.next();
     System.out.println("Digite o local da figura da categoria: ");
     figura = entrada.next();
     
     //Cria um contato e salva no banco
     Categoria categoria = new Categoria();
     categoria.setId(id);
     categoria.setNome(nome);
     categoria.setDescricao(descricao);
     categoria.setFigura(figura);



     //nome,IDfornecedor,IDcategoria,quantidade,precounitario,unidadeestoque,unidadeordem,niveldereposicao,descontinuado
      
     CategoriaDAO.update(categoria);
 
	System.out.println("Categoria editada com sucesso");
 

 }
}