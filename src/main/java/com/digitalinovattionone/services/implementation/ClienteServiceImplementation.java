package com.digitalinovattionone.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalinovattionone.entities.Cliente;
import com.digitalinovattionone.entities.Endereco;
import com.digitalinovattionone.repositories.ClienteRepository;
import com.digitalinovattionone.repositories.EnderecoRepository;
import com.digitalinovattionone.services.ClienteService;
import com.digitalinovattionone.services.ViaCepService;

@Service
public class ClienteServiceImplementation implements ClienteService{

		@Autowired
		private ClienteRepository clienteRepository;
		@Autowired
		private EnderecoRepository enderecoRepository;
		@Autowired
		private ViaCepService viaCepService;
		

		@Override
		public List<Cliente> buscarTodos() {
			return  clienteRepository.findAll();
		}

		@Override
		public Cliente EncontrarPorId(Long id) {
			var cliente= clienteRepository.getReferenceById(id);
			return cliente;
		}

		@Override
		public void inserir(Cliente cliente) {
			salvarClienteComCep(cliente);
		}

		@Override
		public void atualizar(Long id, Cliente cliente) {
			var clienteBd = clienteRepository.findById(id);
			if (clienteBd.isPresent()) {
				salvarClienteComCep(cliente);
			}
		}

		@Override
		public void deletar(Long id) {
			clienteRepository.deleteById(id);
		}

		private void salvarClienteComCep(Cliente cliente) {
			String cep = cliente.getEndereco().getCep();
			Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
				Endereco novoEndereco = viaCepService.consultarCep(cep);
				enderecoRepository.save(novoEndereco);
				return novoEndereco;
			});
			cliente.setEndereco(endereco);
			clienteRepository.save(cliente);
		}

	}
