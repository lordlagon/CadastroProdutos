package br.com.agenda.dao;
 
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Categoria;
 
public class CategoriaDAO {
 
public static void save(Categoria categoria){
 
 /*
 * Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar
 * na base de dados
 */
 
 String sql = "INSERT INTO categoria(nome,descricao,figura)" +
 " VALUES(?,?,?)";
 
 Connection conn = null;
 PreparedStatement pstm = null;
 
 try {
 //Cria uma conexão com o banco
 conn = ConnectionFactory.createConnectionToMySQL();
 
 //Cria um PreparedStatment, classe usada para executar a query
 pstm = conn.prepareStatement(sql);
 
 //Adiciona o valor do primeiro parâmetro da sql
 pstm.setString(1, categoria.getNome());
 pstm.setString(2, categoria.getDescricao());
 pstm.setString(3, categoria.getFigura());



 
 //Executa a sql para inserção dos dados
 pstm.execute();
 
 } catch (Exception e) {
 
 e.printStackTrace();
 }finally{
 
 //Fecha as conexões
 
 try{
 if(pstm != null){
 
 pstm.close();
 }
 
 if(conn != null){
 conn.close();
 }
 
 }catch(Exception e){
 
 e.printStackTrace();
 }
 }
 }
 
 public static void removeById(int id){
 
 String sql = "DELETE FROM categoria WHERE id = ?";
 
 Connection conn = null;
 PreparedStatement pstm = null;
 
 try {
 conn = ConnectionFactory.createConnectionToMySQL();
 
 pstm = conn.prepareStatement(sql);
 
 pstm.setInt(1, id);
 
 pstm.execute();
 
 } catch (Exception e) {
 // TODO Auto-generated catch block
 e.printStackTrace();
 }finally{
 
 try{
 if(pstm != null){
 
 pstm.close();
 }
 
 if(conn != null){
 conn.close();
 }
 
 }catch(Exception e){
 
 e.printStackTrace();
 }
 }
 }
 
 public static void update(Categoria categoria){
 
 String sql = "UPDATE categoria SET nome = ?, descricao = ?, figura = ? " +
 " WHERE id = ?";
 //nome,IDfornecedor,IDcategoria,quantidade,precounitario,unidadeestoque,unidadeordem,niveldereposicao,descontinuado
 
 Connection conn = null;
 PreparedStatement pstm = null;
 
 try {
 //Cria uma conexão com o banco
 conn = ConnectionFactory.createConnectionToMySQL();
 
 //Cria um PreparedStatment, classe usada para executar a query
 pstm = conn.prepareStatement(sql);
 
 pstm.setString(1, categoria.getNome());
 pstm.setString(2, categoria.getDescricao());
 pstm.setString(3, categoria.getFigura());

 
 pstm.setInt(4, categoria.getId());
 
 //Executa a sql para inserção dos dados
 pstm.execute();
 
 } catch (Exception e) {
 
 e.printStackTrace();
 }finally{
 
 //Fecha as conexões
 
 try{
 if(pstm != null){
 
 pstm.close();
 }
 
 if(conn != null){
 conn.close();
 }
 
 }catch(Exception e){
 
 e.printStackTrace();
 }
 }
 }
 
 public List<Categoria> getCategorias(){
 
 String sql = "SELECT * FROM categoria";
 
 List<Categoria> categorias = new ArrayList<Categoria>();
 
 Connection conn = null;
 PreparedStatement pstm = null;
 //Classe que vai recuperar os dados do banco de dados
 ResultSet rset = null;
 
 try {
 conn = ConnectionFactory.createConnectionToMySQL();
 
 pstm = conn.prepareStatement(sql);
 
 rset = pstm.executeQuery();
 
 //Enquanto existir dados no banco de dados, faça
 while(rset.next()){
 
 Categoria categoria = new Categoria();
 
 //Recupera o id do banco e atribui ele ao objeto
 categoria.setId(rset.getInt("id"));
 
 //Recupera o nome do banco e atribui ele ao objeto
 categoria.setNome(rset.getString("nome"));
 
 categoria.setDescricao(rset.getString("descricao"));
 
 //Recupera a idade do banco e atribui ele ao objeto
 categoria.setFigura(rset.getString("figura"));
 


 
 
//nome,IDfornecedor,IDcategoria,quantidade,precounitario,unidadeestoque,unidadeordem,niveldereposicao,descontinuado

 
 //Adiciono o contato recuperado, a lista de contatos
 categorias.add(categoria);
 }
 } catch (Exception e) {
 
 e.printStackTrace();
 }finally{
 
 try{
 
 if(rset != null){
 
 rset.close();
 }
 
 if(pstm != null){
 
 pstm.close();
 }
 
 if(conn != null){
 conn.close();
 }
 
 }catch(Exception e){
 
 e.printStackTrace();
 }
 }
 
 return categorias;
 }
}