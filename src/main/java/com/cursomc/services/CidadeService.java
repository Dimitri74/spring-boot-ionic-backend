/**
 * 
 */
package com.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursomc.domain.Cidade;
import com.cursomc.repositories.CidadeRepositorio;

/**
 * @author Marcus Dimitri
 *
 */
@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepositorio repo;

	public List<Cidade> findByEstado(Integer estadoId) {
		return repo.findCidades(estadoId);
	}
}	
