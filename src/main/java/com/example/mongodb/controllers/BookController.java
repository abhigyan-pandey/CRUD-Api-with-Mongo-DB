package com.example.mongodb.controllers;

import com.example.mongodb.entities.Books;
import com.example.mongodb.repositories.BookRepository;
import com.example.mongodb.utilities.MockNotificationUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/book")
    public List<Books> getBooksList() {
        return bookRepository.findAll();
    }

    @GetMapping("/book/{bookId}")
    public Books getBookById(@PathVariable int bookId) {
        Optional<Books> booksOptional = bookRepository.findById(bookId);
        if (booksOptional.isEmpty())
            throw new NoSuchElementException("No book found in the database with id as =" + bookId);
        return booksOptional.get();
    }

    @PostMapping("/book")
    public String saveBook(@RequestBody Books book) {
        bookRepository.save(book);
        MockNotificationUtil.sendMockEmail("Book has been added to the database with id as " + book.getId());
        return "Successfully added the book in the database";
    }

    @DeleteMapping("/book/{bookId}")
    public String deleteById(@PathVariable int bookId) {
        bookRepository.deleteById(bookId);
        MockNotificationUtil.sendMockEmail("Book has been deleted from the database with id as " + bookId);
        return "Successfully deleted the book with id " + bookId;
    }
}
