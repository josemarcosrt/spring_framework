package com.jpa.spring.one.to.many.exception;

public class ClienteNaoEncontradoException extends EntidadeNaoEncontradaException {

  private static final long serialVersionUID = 1L;

  public ClienteNaoEncontradoException(String mensagem) {
	super(mensagem);
  }

  public ClienteNaoEncontradoException(Long estadoId) {
	this(String.format("Não existe um cadastro de estado com código %d", estadoId));
  }
}
