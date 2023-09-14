package com.digitalinovattionone.services;

import java.util.List;

import com.digitalinovattionone.entities.Cliente;

public interface ClienteService {
	List<Cliente> buscarTodos();
	Cliente EncontrarPorId(Long id);
	void inserir(Cliente cliente);
	void atualizar(Long id, Cliente cliente);
	void deletar(Long id);

}
