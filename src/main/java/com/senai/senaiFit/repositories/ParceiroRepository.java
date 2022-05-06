package com.senai.senaiFit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.senaiFit.models.Parceiro;

@Repository
public interface ParceiroRepository extends JpaRepository<Parceiro, Long> {

}
