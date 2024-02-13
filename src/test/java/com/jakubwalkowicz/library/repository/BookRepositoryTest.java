package com.jakubwalkowicz.library.repository;

import com.jakubwalkowicz.library.model.Author;
import com.jakubwalkowicz.library.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//@DataJpaTest
//class BookRepositoryTest {
//
//    @Autowired
//    private BookRepository underTest;
//
//    @Autowired
//    private AuthorRepository underTestAuthor;
//
//    @Test
//    @Transactional
//    void itShouldFindAllBooksForGivenAuthorId() {
//        // given
//        Author author = new Author();
//        author.setName("John");
//        author.setSurname("Kowalski");
//        author.setDateOfBirth(LocalDate.of(2022, 4, 10));
//        underTestAuthor.save(author);
//
//        Author authorSaved = underTestAuthor.findById(author.getId()).orElseThrow();
//        Book firstBook = new Book();
//        Book secondBook = new Book();
//
//        firstBook.setName("Franek Golas");
//        firstBook.setAuthor(authorSaved);
//        firstBook.setPublishingHouse("Kowadelka");
//        firstBook.setReleaseDate(LocalDate.of(2010, 2, 21));
//
//        secondBook.setName("Franek Golas 2");
//        secondBook.setAuthor(authorSaved);
//        secondBook.setPublishingHouse("Kowadelka");
//        secondBook.setReleaseDate(LocalDate.of(2012, 2, 21));
//
//        underTest.save(firstBook);
//        underTest.save(secondBook);
//        // when
//        Optional<List<Book>> allByAuthorId = underTest.findAllByAuthorId(author.getId());
//        // then
//        assertThat(allByAuthorId.isPresent()).isTrue(); // Ensure the Optional is present
//        assertThat(allByAuthorId.get().contains(firstBook)).isTrue(); // Check if the list contains firstBook
//        assertThat(allByAuthorId.get().contains(secondBook)).isTrue(); // Check if the list contains secondBook
//    }
//
//    @Test
//    @Transactional
//    void itShouldFindNoBooksForGivenAuthorId() {
//        // given
//        Author author = new Author();
//        author.setName("John");
//        author.setSurname("Kowalski");
//        author.setDateOfBirth(LocalDate.of(2022, 4, 10));
//        underTestAuthor.save(author);
//
//        Author authorSaved = underTestAuthor.findById(author.getId()).orElseThrow();
//
//        // when
//        Optional<List<Book>> allByAuthorId = underTest.findAllByAuthorId(author.getId());
//        // then
//        assertThat(allByAuthorId.get().isEmpty()).isTrue();
//    }
//}