package com.booklibrary.booklibrary.repository;

import com.booklibrary.booklibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    // Return the list of all books written by the author
    Optional<Book> findAllBooksByAuthorId(Long id);

}
