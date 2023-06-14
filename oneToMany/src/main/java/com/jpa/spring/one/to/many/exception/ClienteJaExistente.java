package com.jpa.spring.one.to.many.exception;

public class ClienteJaExistente extends NegocioException {

	private static final long serialVersionUID = 1L;
	
	public ClienteJaExistente(String mensagem) {
		super(mensagem);
	}

}
