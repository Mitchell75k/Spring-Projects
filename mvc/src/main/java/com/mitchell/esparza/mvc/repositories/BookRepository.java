package com.mitchell.esparza.mvc.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.mitchell.esparza.mvc.models.Book;

// this interface will be used to create a repository that will be used to query the database
//this allows us to use the methods that are already defined in the CrudRepository interface
//the CrudRepository interface is a generic interface that takes in the model type and the primary key type as generic parameters

//this will allows us to create, read, update, and delete instances of the Book class in the database
@Repository
public interface BookRepository extends CrudRepository<Book, Long>{

    // this method retrieves all the books from the database
    List<Book> findAll();

    // this method finds books with descriptions containing the search string
    List<Book> findByDescriptionContaining(String search);

    // this method counts how many titles contain a certain string
    Long countByTitleContaining(String search);

    // this method deletes a book that starts with a specific title
    Long deleteByTitleStartingWith(String search);
}
