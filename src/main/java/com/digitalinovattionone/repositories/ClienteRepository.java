package com.digitalinovattionone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitalinovattionone.entities.Cliente;

@Repository
public interface ClienteRepository  extends JpaRepository<Cliente, Long>{

	}
