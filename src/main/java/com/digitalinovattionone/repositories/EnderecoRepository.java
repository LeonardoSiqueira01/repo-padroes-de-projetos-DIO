package com.digitalinovattionone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitalinovattionone.entities.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, String>{

}
