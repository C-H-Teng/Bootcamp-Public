package com.charlesteng.updateanddelete.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.charlesteng.updateanddelete.models.Book;
import com.charlesteng.updateanddelete.repositories.BookRepository;

@Service
public class BookService {
	// adding book repository as a dependency
	private final BookRepository bookRepo;
	
	public BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}
	
	// returns all books
	public List<Book> allBooks(){
		return bookRepo.findAll();
	}
	
	// creates a book
	public Book createBook(Book b) {
		return bookRepo.save(b);
	}
	
	// retrieves a book
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	
	public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		Book b = findBook(id);
		b.setTitle(title);
		b.setDescription(desc);
		b.setLanguage(lang);
		b.setNumberOfPages(numOfPages);
		
		return bookRepo.save(b);
	}
	
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}

}
