package com.cursomc.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cursomc.domain.Cliente;

/**
 * @author Marcus Dimitri
 *
 */
@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {

	@Transactional(readOnly=true)
	Cliente findByEmail(String email);

	

	//@Transactional(readOnly=true)
	//Cliente findOne(Integer id);
	

}
