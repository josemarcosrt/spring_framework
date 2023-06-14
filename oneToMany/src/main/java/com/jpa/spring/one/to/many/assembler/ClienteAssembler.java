package com.jpa.spring.one.to.many.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jpa.spring.one.to.many.api.model.ClienteModel;
import com.jpa.spring.one.to.many.entity.Cliente;
import com.jpa.spring.one.to.many.request.ClienteInput;


@Component
public class ClienteAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	public ClienteModel toModel(Cliente cliente) {
		return modelMapper.map(cliente, ClienteModel.class);
	}
	
	public void copyToDomainObject(ClienteInput clienteInput, Cliente cliente) {
		modelMapper.map(clienteInput, cliente);
	}

	public List<ClienteModel> toCollectionModel(List<Cliente> clientes) {
		return clientes.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}	
}
