package com.example.library.library_management.repository;

import com.example.library.library_management.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {
    // Find books by publication year
    List<Book> findByPublicationYear(int year);

    // Find genre of a specific book by ID
    
    
    // Delete all books by publication year
    void deleteByPublicationYear(int year);
}
