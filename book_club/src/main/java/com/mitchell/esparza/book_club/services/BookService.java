package com.mitchell.esparza.book_club.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitchell.esparza.book_club.models.Book;
import com.mitchell.esparza.book_club.repositories.BookRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository bRepo;
    
    public List<Book> getAllBooks(){
        return this.bRepo.findAll();
    }
    
    public Book getOneBook(Long id) {
        return this.bRepo.findById(id).orElse(null);
    }
    
    public Book createBook(Book newBook) {
        return this.bRepo.save(newBook);
    }
    
    public Book updateBook(Book updatedBook) {
        return this.bRepo.save(updatedBook);
    }
    
    public void deleteBook(Long id) {
        this.bRepo.deleteById(id);
    }
}

