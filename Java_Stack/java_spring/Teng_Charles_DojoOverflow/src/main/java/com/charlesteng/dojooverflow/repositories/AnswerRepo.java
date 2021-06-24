package com.charlesteng.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.charlesteng.dojooverflow.models.Answer;

@Repository
public interface AnswerRepo extends CrudRepository<Answer, Long> {
	List<Answer> findAll();

}
