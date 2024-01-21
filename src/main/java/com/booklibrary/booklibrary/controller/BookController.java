package com.booklibrary.booklibrary.controller;

import com.booklibrary.booklibrary.model.Book;
import com.booklibrary.booklibrary.service.BookService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@RestController
@RequestMapping("/library/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable Long id) {
        Optional<Book> book = bookService.findBookById(id);

        if (book.isEmpty()) {
            log.warn("No book found of id {}", id);
            return new ResponseEntity<>(NOT_FOUND);
        }

        log.info("Book of id {} found", id);
        return new ResponseEntity<>(book.get(), OK);
    }

    @GetMapping("authors/{authorId}")
    public ResponseEntity<Optional<Book>> findAllBooksByAuthorId (@PathVariable Long authorId) {
        log.info("Response received. author id: {}", authorId);

        Optional<Book> optionalBooks = bookService.findAllBooksByAuthorId(authorId);

        if (optionalBooks.isEmpty()) {
            log.warn("No books found for author id: {}", authorId);
            return new ResponseEntity<>(NOT_FOUND);
        }

        log.info("Books found for author id: {}", authorId);
        return new ResponseEntity<>(optionalBooks, OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Book>> findAllBooks() {
        List<Book> books = bookService.findAllBooks();
        return new ResponseEntity<>(books, OK);
    }

    @PostMapping("")
    public ResponseEntity<Book> addBook(@RequestBody @Valid Book book) {

        if (book == null) {
            log.warn("Wrong input");
            return new ResponseEntity<>(BAD_REQUEST);
        }

        bookService.addBook(book);
        log.info("Book with id: " + book.getId() + " was saved");
        return new ResponseEntity<>(book, OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody @Valid Book book, @PathVariable Long id) {

        Optional<Book> optionalBook = bookService.findBookById(id);
        // Update needed, first you add publishingHouse, author and lastly book
        if (book == null) {
            log.warn("Wrong input");
            return new ResponseEntity<>(BAD_REQUEST);
        }

        if (optionalBook.isEmpty()) {
            log.warn("Book of id {} doesn't exist", id);
            return new ResponseEntity<>(NOT_FOUND);
        }

        Book updatedBook = optionalBook.get();

        updatedBook.setName(book.getName());
        updatedBook.setGenre(book.getGenre());
        updatedBook.setReleaseDate(book.getReleaseDate());
        updatedBook.setPublishingHouse(book.getPublishingHouse());
        updatedBook.setAuthor(book.getAuthor());

        return new ResponseEntity<>(OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {

        Optional<Book> book = bookService.findBookById(id);

        if (book.isEmpty()) {
            log.warn("Wrong input");
            return new ResponseEntity<>(BAD_REQUEST);
        }
        else bookService.deleteBook(id);
        return new ResponseEntity<>(OK);
    }

}
