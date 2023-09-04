package com.mitchell.esparza.book_club.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mitchell.esparza.book_club.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
        
        List<Book> findAll();
        
}