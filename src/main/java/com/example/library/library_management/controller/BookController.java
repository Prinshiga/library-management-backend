package com.example.library.library_management.controller;

import com.example.library.library_management.model.Book;
import com.example.library.library_management.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable String id) {
        return bookService.getBookById(id);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable String id, @RequestBody Book book) {
        book.setId(id);
        return bookService.updateBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable String id) {
        bookService.deleteBookById(id);
    }

    @GetMapping("/year/{year}")
    public List<Book> findBooksByPublicationYear(@PathVariable int year) {
        return bookService.findBooksByPublicationYear(year);
    }

    @GetMapping("/genre/{id}")
    public String getGenre(@PathVariable String id) {
        return bookService.getGenreByBookId(id);
    }

    @DeleteMapping("/year/{year}")
    public void deleteBooksByYear(@PathVariable int year) {
        bookService.deleteBooksByPublicationYear(year);
    }
}
