package com.senai.senaiFit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.senaiFit.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
