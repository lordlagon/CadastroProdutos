

import br.com.agenda.dao.CategoriaDAO;
import br.com.agenda.model.Categoria;
public class ListarCategorias {
 
public static void main(String args[]){
 
CategoriaDAO categoriaDAO = new CategoriaDAO();
 


 //Lista todos os contatos do banco de dados
 
for(Categoria c : categoriaDAO.getCategorias()){
 
	 System.out.println("Id: " + c.getId() + " | NOME: " + c.getNome() + " | Descrição: " + c.getDescricao() + " | Figura: " + c.getFigura());
 }
 }
}