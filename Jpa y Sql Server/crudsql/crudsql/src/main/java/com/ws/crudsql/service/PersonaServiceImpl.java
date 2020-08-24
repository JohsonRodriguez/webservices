package com.ws.crudsql.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.ws.crudsql.dao.IPersonaDao;
import com.ws.crudsql.model.Persona;

// Ctrl + 1 --> para implementar los metodos de la interfaz
@Service
public class PersonaServiceImpl implements IPersonaService {

	@Autowired
	private IPersonaDao personaDao;
	
	@Override
	public Persona registrar(Persona t) {
		System.out.println(t.toString());
		return personaDao.save(t);
	}

	@Override
	public Persona modificar(Persona t) {
		return personaDao.save(t);
	}

	@Override
	public boolean eliminar(Long id) {
	 Optional<Persona> _p = personaDao.findById(id);
		if(_p != null) {
			personaDao.delete(_p.get());
			return true;
		}
		return false;
	}

	@Override
	public Persona listarId(Long id) {
		return personaDao.findById(id).get();
	}

	@Override
	public List<Persona> listar() {
		return personaDao.findAll();
	}

	@Override
	public Page<Persona> listarPageable(Pageable pageable) {
		return personaDao.findAll(pageable);
	}

}
