package net.tibrasil.osworks.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.tibrasil.osworks.api.exceptionhandler.NegocioException;
import net.tibrasil.osworks.domain.model.Cliente;
import net.tibrasil.osworks.domain.repository.ClienteRepository;

@Service
public class CadastroClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente salvar(Cliente cliente) {
		
		Cliente clienteExistente = clienteRepository.findByEmail(cliente.getEmail());
		if(clienteExistente != null && !clienteExistente.equals(cliente)) {
			throw new NegocioException("Já existe um cliente cadastrado com este email");
		}
		
		return clienteRepository.save(cliente);
	}
	
	public void excluir(Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}
	
}
