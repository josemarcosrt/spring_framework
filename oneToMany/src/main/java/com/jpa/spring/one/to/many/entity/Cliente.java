package com.jpa.spring.one.to.many.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false) 
public class Cliente extends AbstractAggregateRoot<Cliente>{
	
	@Id
	@EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name = "id")
    private Long id;

    @Column(name = "no_cliente")
    private String noCliente;

    @Column(name = "nu_cpf")
    private String nuCpf;

    @Column(name = "dt_criado")
    @CreatedDate
    private Date dtCriado;

    @Column(name = "dt_modificado")
    @LastModifiedDate
    private Date dtModificado;

    @CreatedBy
    @Column(name = "co_usuario_cadastro")
    private String coUsuarioCadastro;

    //@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "cliente") // @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)  ,orphanRemoval = true, fetch = FetchType.EAGER @JoinColumn(name = "id", referencedColumnName = "id")          @JoinColumn(name = "id", referencedColumnName = "id")
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Email> emails = new ArrayList<>();


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

	public List<Email> getEmails() {
		return emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}

	
}




