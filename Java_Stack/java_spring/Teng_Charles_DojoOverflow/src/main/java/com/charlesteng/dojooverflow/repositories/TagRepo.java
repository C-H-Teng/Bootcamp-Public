package com.charlesteng.dojooverflow.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.charlesteng.dojooverflow.models.Tag;

@Repository
public interface TagRepo extends CrudRepository<Tag, Long> {
	List<Tag> findAll();
	
	Optional<Tag> findBySubject(String search);

}
