package com.senai.senaiFit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.senaiFit.models.Checkin;

@Repository
public interface CheckinRepository extends JpaRepository<Checkin, Long> {

}
