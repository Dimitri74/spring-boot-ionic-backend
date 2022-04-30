/**
 * 
 */
package com.cursomc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cursomc.domain.Estado;

/**
 * @author Marcus Dimitri
 *
 */
@Repository
public interface EstadoRepositorio extends JpaRepository<Estado ,Integer>   {
	
	@Transactional(readOnly=true)
	public List<Estado> findAllByOrderByNome();

}
