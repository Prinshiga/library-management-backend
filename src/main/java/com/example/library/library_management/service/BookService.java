package com.example.library.library_management.service;

import com.example.library.library_management.model.Book;
import java.util.List;

public interface BookService {

    Book addBook(Book book);

    List<Book> getAllBooks();

    Book getBookById(String id);

    Book updateBook(Book book);

    void deleteBookById(String id);

    List<Book> findBooksByPublicationYear(int year);

    String getGenreByBookId(String id);

    void deleteBooksByPublicationYear(int year);
}
