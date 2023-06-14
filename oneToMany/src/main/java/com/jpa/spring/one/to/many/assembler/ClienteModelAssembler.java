package com.jpa.spring.one.to.many.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.jpa.spring.one.to.many.api.model.ClienteModel;
import com.jpa.spring.one.to.many.entity.Cliente;

import com.jpa.spring.one.to.many.resource.ClienteResource;

@Component
public class ClienteModelAssembler  extends RepresentationModelAssemblerSupport<Cliente, ClienteModel> {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public ClienteModelAssembler() {
		super(ClienteResource.class, ClienteModel.class);
	}
	
	@Override
	public ClienteModel toModel(Cliente cliente) {
		ClienteModel clienteModel = createModelWithId(cliente.getId(), cliente);
		modelMapper.map(cliente, clienteModel);
		return clienteModel;
	}
}

