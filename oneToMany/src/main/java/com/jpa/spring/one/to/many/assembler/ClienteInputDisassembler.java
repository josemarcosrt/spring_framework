package com.jpa.spring.one.to.many.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jpa.spring.one.to.many.entity.Cliente;
import com.jpa.spring.one.to.many.request.ClienteInput;

@Component
public class ClienteInputDisassembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Cliente toDomainObject(ClienteInput cliente) {
		cliente.getEmails().forEach(item -> {
			System.out.print(" toDomainObject item : "+item.getDsEmail());
		});
		return modelMapper.map(cliente, Cliente.class);
	}
	
	public void copyToDomainObject(ClienteInput clienteInput, Cliente cliente) {
		modelMapper.map(clienteInput, cliente);
	}
	

	public Cliente toEntity(ClienteInput entregaInput) {
	
		entregaInput.getEmails().forEach(item -> {
			System.out.print(" toDomainObject item : "+item.getDsEmail());
		});
		return modelMapper.map(entregaInput, Cliente.class);
	}
	
	
	
}