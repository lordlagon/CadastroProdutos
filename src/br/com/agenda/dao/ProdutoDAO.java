package br.com.agenda.dao;
 
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Produto;
 
public class ProdutoDAO {
 
public static void save(Produto produto){
 
 /*
 * Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar
 * na base de dados
 */
 
 String sql = "INSERT INTO produtos(nome,IDfornecedor,IDcategoria,quantidade,precounitario,unidadeestoque,unidadeordem,niveldereposicao,descontinuado)" +
 " VALUES(?,?,?,?,?,?,?,?,?)";
 
 Connection conn = null;
 PreparedStatement pstm = null;
 
 try {
 //Cria uma conexão com o banco
 conn = ConnectionFactory.createConnectionToMySQL();
 
 //Cria um PreparedStatment, classe usada para executar a query
 pstm = conn.prepareStatement(sql);
 
 //Adiciona o valor do primeiro parâmetro da sql
 pstm.setString(1, produto.getNome());
 pstm.setInt(2, produto.getIDfornecedor());
 pstm.setInt(3, produto.getIDcategoria());
 pstm.setString(4, produto.getQuantidade());
 pstm.setString(5, produto.getPrecounitario());
 pstm.setLong(6, produto.getUnidadeestoque());
 pstm.setLong(7, produto.getUnidadeordem());
 pstm.setLong(8, produto.getNiveldereposicao());
 pstm.setString(9, produto.getDescontinuado());


 
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
 
 String sql = "DELETE FROM produtos WHERE id = ?";
 
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
 
 public static void update(Produto produto){
 
 String sql = "UPDATE produtos SET nome = ?, IDfornecedor = ?, IDcategoria = ?, quantidade = ?,precounitario = ?,unidadeestoque = ?,unidadeordem = ?,niveldereposicao = ?,descontinuado = ? " +
 " WHERE id = ?";
 //nome,IDfornecedor,IDcategoria,quantidade,precounitario,unidadeestoque,unidadeordem,niveldereposicao,descontinuado
 
 Connection conn = null;
 PreparedStatement pstm = null;
 
 try {
 //Cria uma conexão com o banco
 conn = ConnectionFactory.createConnectionToMySQL();
 
 //Cria um PreparedStatment, classe usada para executar a query
 pstm = conn.prepareStatement(sql);
 
 pstm.setString(1, produto.getNome());
 pstm.setInt(2, produto.getIDfornecedor());
 pstm.setInt(3, produto.getIDcategoria());
 pstm.setString(4, produto.getQuantidade());
 pstm.setString(5, produto.getPrecounitario());
 pstm.setLong(6, produto.getUnidadeestoque());
 pstm.setLong(7, produto.getUnidadeordem());
 pstm.setLong(8, produto.getNiveldereposicao());
 pstm.setString(9, produto.getDescontinuado());
 
 pstm.setInt(10, produto.getId());
 
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
 
 public List<Produto> getProdutos(){
 
 String sql = "SELECT * FROM produtos";
 
 List<Produto> produtos = new ArrayList<Produto>();
 
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
 
 Produto produto = new Produto();
 
 //Recupera o id do banco e atribui ele ao objeto
 produto.setId(rset.getInt("id"));
 
 //Recupera o nome do banco e atribui ele ao objeto
 produto.setNome(rset.getString("nome"));
 
 //Recupera a idade do banco e atribui ele ao objeto
 produto.setIDfornecedor(rset.getInt("IDfornecedor"));
 
 //Recupera a idade do banco e atribui ele ao objeto
 produto.setIDcategoria(rset.getInt("IDcategoria"));
 produto.setQuantidade(rset.getString("quantidade"));
 produto.setPrecounitario(rset.getString("precounitario"));
 
 produto.setUnidadeestoque(rset.getInt("unidadeestoque"));
 produto.setUnidadeordem(rset.getInt("unidadeordem"));
 produto.setNiveldereposicao(rset.getInt("niveldereposicao"));
 
 produto.setDescontinuado(rset.getString("descontinuado"));
 

 
 
//nome,IDfornecedor,IDcategoria,quantidade,precounitario,unidadeestoque,unidadeordem,niveldereposicao,descontinuado

 
 //Adiciono o contato recuperado, a lista de contatos
 produtos.add(produto);
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
 
 return produtos;
 }
}