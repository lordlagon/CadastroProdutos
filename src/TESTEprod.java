
 
import br.com.agenda.dao.CategoriaDAO;
import br.com.agenda.model.Categoria;
public class TESTEprod {
 
public static void main(String args[]){
 
CategoriaDAO categoriaDAO = new CategoriaDAO();
 
 //Cria um contato e salva no banco
Categoria categoria = new Categoria();
categoria.setNome("Alimentos");
categoria.setDescricao("produtos que são alimentos");
categoria.setFigura("http://www.google.com.br/");



//nome,IDfornecedor,IDcategoria,quantidade,precounitario,unidadeestoque,unidadeordem,niveldereposicao,descontinuado
 
CategoriaDAO.save(categoria);
 

 //Lista todos os contatos do banco de dados
 
for(Categoria c : categoriaDAO.getCategorias()){
 
	 System.out.println("NOME: " + c.getNome());
 }
 }
}