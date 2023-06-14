package com.jpa.spring.one.to.many.request;

import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class ClienteInput {
	
	public Long id;
    public String noCliente;
    public String nuCpf;
    public Date dtCriado;
    public Date dtModificado;
    public String coUsuarioCadastro;
    
    public List<EmailInput> emails;
    
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
	public List<EmailInput> getEmails() {
		return emails;
	}
	public void setEmails(List<EmailInput> emails) {
		this.emails = emails;
	}      
}
