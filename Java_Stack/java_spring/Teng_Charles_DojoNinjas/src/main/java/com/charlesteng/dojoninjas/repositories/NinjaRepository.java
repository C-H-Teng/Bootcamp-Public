package com.charlesteng.dojoninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.charlesteng.dojoninjas.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {
	List<Ninja> findAll();
	
//	List<Ninja> findByFirst_nameContaining(String search);
	
//	List<Ninja> findByLast_nameContaining(String search);
	
//	Long deleteByNameStartingWith(Long search);
	
	List<Ninja> findByDojoIsNotNull();
	
	List<Ninja> findByDojo_id(Long search);

}
