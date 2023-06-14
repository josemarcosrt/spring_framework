package com.jpa.spring.one.to.many.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import  com.jpa.spring.one.to.many.entity.Cliente;
import com.jpa.spring.one.to.many.exception.BusinessException;
import com.jpa.spring.one.to.many.exception.ClienteJaExistente;
import com.jpa.spring.one.to.many.exception.ClienteNaoEncontradoException;
import com.jpa.spring.one.to.many.repository.ClienteRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class ClienteService  {
  
  @Autowired
  private ClienteRepository repository;

  private void addEimals(Cliente cliente) {
    cliente.getEmails().forEach(item -> {
      	item.setCliente(cliente);
	});
  }
  
  public Cliente salvar(Cliente cliente) {
    
    boolean cpfEmUso = repository.findByNuCpf(cliente.getNuCpf())
			.stream()
			.anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
   
	if (cpfEmUso) {
		throw new ClienteJaExistente("Já existe um cliente cadastrado com CPF.");
	}
	addEimals(cliente);
	return repository.save(cliente);
  }

  public Cliente alterar(Long id, Cliente paciente) {
        Optional<Cliente> optPaciente = this.buscarPorId(id);

        if (optPaciente.isEmpty()) {
            throw new BusinessException("Paciente não cadastrado!");
        }

        paciente.setId(id);

        return salvar(paciente);
  }

  public Cliente buscarOuFalhar(Long clienteId) {
		return repository.findById(clienteId)
			.orElseThrow(() -> new ClienteNaoEncontradoException(clienteId));
  }
  
  public List<Cliente> listarTodos() {
        return repository.findAll();
  }

  public Optional<Cliente> buscarPorId(Long id) {
        return repository.findById(id);
  }

  public void deletar(Long id) {
	  repository.deleteById(id);
  }

}