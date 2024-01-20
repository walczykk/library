package com.booklibrary.booklibrary.service;

import com.booklibrary.booklibrary.model.Book;
import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAllBooks();

    Optional<Book> findAllBooksByAuthorId(Long id);

    Book addBook(Book book);

    Book updateBook(Book book, Long id);

    Boolean deleteBook(Long id);

    Optional<Book> findBookById(Long id);
}
//In this example, the updateBookAndAuthor method performs two database operations: updating the title of a book and updating the name of the book's author. These operations should be treated atomically; either both should succeed, or both should fail. If an exception occurs at any point within the method, Spring will automatically roll back the entire transaction, ensuring that the data remains consistent.
//
//Without @Transactional, each database operation would be treated as a separate transaction, and if an exception occurred after the first operation, you might end up with inconsistent data in your database.
//
//Using @Transactional in this case helps you manage the boundaries of the transaction, providing data integrity and consistency in scenarios where multiple operations need to be executed together.
