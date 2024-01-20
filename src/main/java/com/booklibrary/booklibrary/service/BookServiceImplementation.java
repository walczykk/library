package com.booklibrary.booklibrary.service;
import com.booklibrary.booklibrary.model.Book;
import com.booklibrary.booklibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import static java.lang.Boolean.*;

@Service
public class BookServiceImplementation implements BookService{


    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImplementation(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional(readOnly = true)
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Optional<Book> findAllBooksByAuthorId(Long id) {
        Optional<Book> book = bookRepository.findAllBooksByAuthorId(id);

        if (book.isPresent()) {
            return book;
        }
        else throw new IllegalStateException("No books with author id: " + id + " were found");
    }

    @Override
    public Book addBook(Book book) { return bookRepository.save(book); }

    @Transactional
    @Override
    public Book updateBook(Book book, Long id) {
        Optional<Book> existingBookOptional = bookRepository.findById(id);

        if (existingBookOptional.isPresent()) {
            Book existingBook = existingBookOptional.get();
            existingBook = book;

            return bookRepository.save(existingBook);
        }
        else throw new IllegalStateException("Book with id: " + id + " was not found");
    }

    @Transactional
    @Override
    public Boolean deleteBook(Long id) {

        if (bookRepository.findById(id).isPresent()) {
            bookRepository.deleteById(id);
            return TRUE;
        }
        throw new IllegalStateException("Book with id" + id + " was not found");
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Book> findBookById(Long id) {

        Optional<Book> book = bookRepository.findById(id);

        if (book.isPresent()) {
            return book;
        }

        throw new IllegalStateException("Book with id: " + id + " was not found");
    }
}
