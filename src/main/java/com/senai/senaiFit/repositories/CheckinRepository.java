package com.senai.senaiFit.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.senai.senaiFit.models.Checkin;

@Repository
public interface CheckinRepository extends JpaRepository<Checkin, Long> {

	@Query("SELECT c FROM Checkin c INNER JOIN c.cliente WHERE c.cliente.id = ?1 AND c.dataCheckin >= ?2 AND c.dataCheckin <= ?3")
	List<Checkin> findChickinByCliente(long id, LocalDate inicio, LocalDate fim);
}
