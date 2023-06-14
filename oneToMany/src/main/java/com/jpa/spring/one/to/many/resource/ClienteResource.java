package com.jpa.spring.one.to.many.resource;

import java.util.List;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.jpa.spring.one.to.many.api.model.ClienteModel;
import com.jpa.spring.one.to.many.assembler.ClienteAssembler;
import com.jpa.spring.one.to.many.assembler.ClienteInputDisassembler;
import com.jpa.spring.one.to.many.assembler.ClienteModelAssembler;
import com.jpa.spring.one.to.many.entity.Cliente;
import com.jpa.spring.one.to.many.exception.ClienteJaExistente;
import com.jpa.spring.one.to.many.exception.ClienteNaoEncontradoException;
import com.jpa.spring.one.to.many.exception.NegocioException;
import com.jpa.spring.one.to.many.repository.ClienteRepository;
import com.jpa.spring.one.to.many.request.ClienteInput;
import com.jpa.spring.one.to.many.service.ClienteService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ClienteResource {

	@Value("${nome.aplicacao}")
    private String applicationName;
    
    @Autowired
    private ClienteRepository clienteRepository;
    
	@Autowired
    private ClienteAssembler clienteAssembler;
	
	@Autowired
    private ClienteInputDisassembler clienteInputDisassembler;
    
    @Autowired
    private ClienteModelAssembler clienteModelAssembler;
    
    @Autowired
    private ClienteService service;
    
	@ApiOperation(value = "Lista paginada com todos os clientes.")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Lista de clientes."),
	        @ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso."),
	        @ApiResponse(code = 500, message = "Erro inesperado no servidor.")
	})
	@GetMapping("/clientes")
	public List<ClienteModel> getAllClientes() {
		System.out.print("LISTANDO TUDO: ");
		return clienteAssembler.toCollectionModel(clienteRepository.findAll());
	}
	
	
	@ApiOperation(value = "Cadastro de cliente.")
	@ApiResponses(value = {
	        @ApiResponse(code = 201, message = "Cliente cadastrado com sucesso."),
	        @ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso."),
	        @ApiResponse(code = 500, message = "Erro inesperado no servidor.")
	    })
	 
	@PostMapping("/clientes/cadastro")  // @PreAuthorize("hasRole('ADMIN')") // @ResponseStatus(HttpStatus.CREATED)
	public ClienteModel createCliente(@Valid @RequestBody  ClienteInput  request) { 
	
	    Cliente novoCliente = clienteInputDisassembler.toEntity(request);
		try {
			Cliente clienteSalvo = service.salvar(novoCliente);
		    return  clienteModelAssembler.toModel(clienteSalvo);
		} catch (ClienteJaExistente e) {
			throw new NegocioException(e.getMessage(), e);
		} 
		
	}
	@ApiOperation(value = "Atualizar cliente.")
	@ApiResponses(value = {
	        @ApiResponse(code = 201, message = "Cliente Atulaizado com sucesso."),
	        @ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso."),
	        @ApiResponse(code = 403, message = "Você é proibido de acessar este recurso."),
	        @ApiResponse(code = 500, message = "Erro inesperado no servidor.")
	})
	@PutMapping("/clientes/atualizar/{clienteId}") // @ResponseStatus(HttpStatus.GONE)
	public ClienteModel atualizar(@PathVariable Long clienteId, @RequestBody @Valid ClienteInput clienteInput) {
    	try {
    		System.out.println("José Marcos");
    		Cliente clienteAtual = service.buscarOuFalhar(clienteId);
    		clienteInputDisassembler.copyToDomainObject(clienteInput, clienteAtual);
    		clienteAtual = service.salvar(clienteAtual);
			return  clienteModelAssembler.toModel(clienteAtual);
    	}catch (ClienteNaoEncontradoException e) {
    		throw new NegocioException(e.getMessage(), e);
    	}
    }
				
	 
	@DeleteMapping("/{clienteId}")
	public ResponseEntity<Void> remover(@PathVariable Long clienteId) {
		if (!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		service.deletar(clienteId);
	
		return ResponseEntity.noContent().build();
	}
	    
}
