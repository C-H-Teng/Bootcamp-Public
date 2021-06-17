package com.charlesteng.updateanddelete.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.charlesteng.updateanddelete.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
	// retrieves all books from the db
	List<Book> findAll();
	
	// finds books with descriptions containing search string
	List<Book> findByDescriptionContaining(String search);
	
	//counts how many titles contain certain string
	Long countByTitleContaining(String search);
	
	// deletes a book that starts with specific title
	Long deleteByTitleStartingWith(String search);
}
