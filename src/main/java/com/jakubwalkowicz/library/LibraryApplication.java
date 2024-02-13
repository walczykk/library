package com.jakubwalkowicz.library;

import com.jakubwalkowicz.library.model.Author;
import com.jakubwalkowicz.library.model.Book;
import com.jakubwalkowicz.library.repository.AuthorRepository;
import com.jakubwalkowicz.library.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDate;

@SpringBootApplication
@ComponentScan(basePackages = "com.jakubwalkowicz.library")
public class LibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }
}
