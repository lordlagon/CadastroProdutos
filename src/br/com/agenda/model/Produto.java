package br.com.agenda.model;
 
 
public class Produto {
 
 private int id;
 private String nome;
 private int IDfornecedor;
 private int IDcategoria;
 private String quantidade;
 private String precounitario;
 private int unidadeestoque;
 private int unidadeordem;
 private int niveldereposicao;
 private String descontinuado;
 
 public int getId() {
 return id;
 }
 
 public void setId(int id) {
 this.id = id;
 }
 /////////////////////////////////////
 public String getNome() {
 return nome;
 }
 
 public void setNome(String nome) {
 this.nome = nome;
 }
 /////////////////////////////////////
 public int getIDfornecedor() {
 return IDfornecedor;
 }
 
 public void setIDfornecedor(int IDfornecedor) {
 this.IDfornecedor = IDfornecedor;
 }
 /////////////////////////////////////
 public int getIDcategoria() {
 return IDcategoria;
 }
 
 public void setIDcategoria(int IDcategoria) {
 this.IDcategoria = IDcategoria;
 }
 /////////////////////////////////////
 public String getQuantidade() {
 return quantidade;
 }
 
 public void setQuantidade(String quantidade) {
 this.quantidade = quantidade;
 }
 /////////////////////////////////////
 public String getPrecounitario() {
 return precounitario;
 }
 
 public void setPrecounitario(String precounitario) {
 this.precounitario = precounitario;
 }
 /////////////////////////////////////
 public int getUnidadeestoque() {
 return unidadeestoque;
 }
 
 public void setUnidadeestoque(int unidadeestoque) {
 this.unidadeestoque = unidadeestoque;
 }
 /////////////////////////////////////
 public int getUnidadeordem() {
 return unidadeordem;
 }
 
 public void setUnidadeordem(int unidadeordem) {
 this.unidadeordem = unidadeordem;
 }
 /////////////////////////////////////
 public int getNiveldereposicao() {
 return niveldereposicao;
 }
 
 public void setNiveldereposicao(int niveldereposicao) {
 this.niveldereposicao = niveldereposicao;
 }
 /////////////////////////////////////
 public String getDescontinuado() {
 return descontinuado;
 }
 
 public void setDescontinuado(String descontinuado) {
 this.descontinuado = descontinuado;
 }
}

