package com.ws.crudsql.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ws.crudsql.model.Persona;
import com.ws.crudsql.service.IPersonaService;

@RestController
@RequestMapping("/personas")
public class PersonaController {

	@Autowired
	private IPersonaService service;
	
	@GetMapping
	public ResponseEntity<List<Persona>>  listar() throws IOException
	{
		List<Persona> lista =service.listar();  //null;
		if(lista == null) {
			lista = new ArrayList<>();
			//throw new IOException("Error al listar");
		}
		return new ResponseEntity<>(lista, HttpStatus.OK);
		
	}
	
	@GetMapping(value="listar/{id}")
	public ResponseEntity<Persona>  listarID(@PathVariable("id") Long id) throws IOException
	{
		Persona _p =service.listarId(id);
		if(_p == null) {
			_p = new Persona();
			//throw new IOException("Error al obtener persona");
		}
		return new ResponseEntity<>(_p, HttpStatus.OK);
		
	}
	
	@GetMapping(value="paginar")
	public ResponseEntity<Page<Persona>> pageable(Pageable pageable){
		Page<Persona> personas;
		personas = service.listarPageable(pageable);
		return new ResponseEntity<>(personas, HttpStatus.OK);
	}
	
	
	
	@PostMapping(value="crear")
	public ResponseEntity<Persona> save(@RequestBody Persona p)
	{
		System.out.println(p.toString());
		Persona _p = service.registrar(p);
		if(_p == null)
			return new ResponseEntity<Persona>(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(_p, HttpStatus.CREATED);
	}
	
	@PutMapping(value="actualizar")
	public ResponseEntity<Persona> update(@RequestBody Persona p)
	{
		
		Persona _p = service.modificar(p);
		if(_p == null)
			return new ResponseEntity<Persona>(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(_p, HttpStatus.OK);
	}
	
	@DeleteMapping(value="eliminar/{id}")
	public boolean delete(@PathVariable("id") Long id)
	{
		
		return service.eliminar(id);
	
	}

}
