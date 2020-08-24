package com.ws.crudsql.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.ws.crudsql.model.Persona;

public interface IPersonaService {

	Persona registrar(Persona t);
	
	Persona modificar(Persona t);

	boolean eliminar(Long id);

	Persona listarId(Long id);

	List<Persona> listar();
	
	Page<Persona> listarPageable(Pageable pageable);
	
}
