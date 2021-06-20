package com.charlesteng.dojoninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.charlesteng.dojoninjas.models.Dojo;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long> {
	List<Dojo> findAll();
	
//	List<Dojo> findByNameStartingWith(Long search);
	
	List<Dojo> findByNameContaining(String search);
	
	Long deleteByNameStartingWith(Long search);
	

}
