

import br.com.agenda.dao.ProdutoDAO;
import br.com.agenda.model.Produto;
public class ListarProduto {
 
public static void main(String args[]){
 
	ProdutoDAO produtoDAO = new ProdutoDAO();
 


 //Lista todos os contatos do banco de dados
 
for(Produto c : produtoDAO.getProdutos()){
 
	 System.out.println("Id: " + c.getId() + " | NOME: " + c.getNome());
 }
 }
}