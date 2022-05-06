package com.senai.senaiFit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.senaiFit.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
