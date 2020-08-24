package com.ws.crudsql.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ws.crudsql.model.Persona;

public interface IPersonaDao extends JpaRepository<Persona, Long> {

}
