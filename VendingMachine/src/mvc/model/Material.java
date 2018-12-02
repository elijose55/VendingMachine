package mvc.model;

import java.util.Calendar;

public class Material {
 private Long id;
 private String nome;
 private Integer quantidade;
 private Integer vendas;
 private Integer preco;
 
 public Long getId() {return id;}
 public void setId(Long id) {this.id = id;}
 
 public String getNome() {return nome;}
 public void setNome(String nome) {this.nome = nome;}
 
 public Integer getQuantidade() {return quantidade;}
 public void setQuantidade(Integer quantidade) {this.quantidade = quantidade;}
 
 public Integer getVendas() {return vendas;}
 public void setVendas(Integer vendas) {this.vendas = vendas;}
 
 public Integer getPreco() {return preco;}
 public void setPreco(Integer preco) {this.preco = preco;}
 
 //public boolean isFinalizado() {return finalizado;}
 //public void setFinalizado(boolean finalizado) {this.finalizado = finalizado;}
 //public Calendar getDataFinalizacao() {return dataFinalizacao;}
 //public void setDataFinalizacao(Calendar dataFinal) {this.dataFinalizacao = dataFinal;}
}