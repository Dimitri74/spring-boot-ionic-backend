/**
 * 
 */
package com.cursomc.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cursomc.domain.Categoria;
import com.cursomc.dto.CategoriaDTO;
import com.cursomc.services.CategoriaServico;

/**
 * @author Marcus Dimitri
 *
 */

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaRecurso {

	@Autowired
	private CategoriaServico service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Categoria obj = service.find(id);
		return ResponseEntity.ok().body(obj);

	}

	// Para Testes

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Categoria obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	/*
	 * //@PreAuthorize("hasAnyRole('ADMIN')")
	 * 
	 * @RequestMapping(method=RequestMethod.POST) public ResponseEntity<Void>
	 * insert( @RequestBody CategoriaDTO objDto) { //@Valid Categoria obj =
	 * service.fromDTO(objDto); obj = service.insert(obj); URI uri =
	 * ServletUriComponentsBuilder.fromCurrentRequest()
	 * .path("/{id}").buildAndExpand(obj.getId()).toUri(); return
	 * ResponseEntity.created(uri).build(); }
	 */

	// Codigos para fins de teste. Serve como base para o inicio de implementação.

}
