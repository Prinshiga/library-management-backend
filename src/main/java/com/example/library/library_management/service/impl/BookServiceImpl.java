package com.example.library.library_management.service.impl;

import com.example.library.library_management.model.Book;
import com.example.library.library_management.repository.BookRepository;
import com.example.library.library_management.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(String id) {
        // This is the code I mentioned earlier
        return bookRepository.findById(id).orElse(null);
    }
    @Override
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBookById(String id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> findBooksByPublicationYear(int year) {
        return bookRepository.findByPublicationYear(year);
    }

    @Override
    public String getGenreByBookId(String id) {
        Book book = getBookById(id);
        return book != null ? book.getGenre() : null;
    }

    @Override
    public void deleteBooksByPublicationYear(int year) {
        bookRepository.deleteByPublicationYear(year);
    }
}

