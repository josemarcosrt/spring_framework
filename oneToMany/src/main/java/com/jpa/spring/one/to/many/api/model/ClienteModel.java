package com.jpa.spring.one.to.many.api.model;

import java.util.Date;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Relation(collectionRelation = "clientes")
@Getter
@Setter
public class ClienteModel extends RepresentationModel<ClienteModel> { 

  private Long id;
  private String noCliente;
  private String nuCpf;
  private Date dtCriado;
  private Date dtModificado;
  private String coUsuarioCadastro;
  private List<EmailModel> emails;
 
  
  public Long getId() {  
	return id;
  }
  public void setId(Long id) {
	this.id = id;
  }
  public String getNoCliente() {
	return noCliente;
  }
  public void setNoCliente(String noCliente) {
	this.noCliente = noCliente;
  }
  public String getNuCpf() {
	return nuCpf;
  }
  public void setNuCpf(String nuCpf) {
	this.nuCpf = nuCpf;
  }
  public Date getDtCriado() {
	return dtCriado;
  }
  public void setDtCriado(Date dtCriado) {
	this.dtCriado = dtCriado;
  }
  public Date getDtModificado() {
	return dtModificado;
  }
  public void setDtModificado(Date dtModificado) {
	this.dtModificado = dtModificado;
  }
 
  public String getCoUsuarioCadastro() {
	return coUsuarioCadastro;
  }
  public void setCoUsuarioCadastro(String coUsuarioCadastro) {
	this.coUsuarioCadastro = coUsuarioCadastro;
  }
  
  public List<EmailModel> getEmails() {
	return emails;
  }
  public void setEmails(List<EmailModel> emails) {
	this.emails = emails;
  }
   
}