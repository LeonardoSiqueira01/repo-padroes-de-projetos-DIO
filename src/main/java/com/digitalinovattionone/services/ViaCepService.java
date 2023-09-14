package com.digitalinovattionone.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.digitalinovattionone.entities.Endereco;

@FeignClient(name = "viacep", url = "viacep.com.br/ws/")
public interface ViaCepService {
	@GetMapping
	Endereco consultarCep(@PathVariable("cep") String cep);

}
