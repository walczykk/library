package com.jakubwalkowicz.library.service;

import com.jakubwalkowicz.library.model.Book;
import com.jakubwalkowicz.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.lang.Boolean.TRUE;

@Service
@RequiredArgsConstructor
public class BookServiceImplementation implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(bookOptional.isEmpty()){
            throw new IllegalStateException("No book of id: " + id + " was found");
        }
        return bookOptional;
    }

    @Override
    public Book add(Book book) {
        if (book == null) {
            throw new IllegalStateException("Wrong input");
        }
        return bookRepository.save(book);
    }

    @Override
    public Book update(Book book, Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isEmpty()) {
            throw new IllegalStateException("No book of id: " + id + " was found");
        }
        Book existingBook = bookOptional.get();
        existingBook.setAuthor(book.getAuthor());
        existingBook.setName(book.getName());
        existingBook.setPublishingHouse(book.getPublishingHouse());
        existingBook.setReleaseDate(book.getReleaseDate());
        return bookRepository.save(existingBook);
    }

    @Override
    public Boolean delete(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isEmpty()) {
            throw new IllegalStateException("No book of id: " + id + " was found");
        }
        bookRepository.deleteById(id);
        return TRUE;
    }
}
