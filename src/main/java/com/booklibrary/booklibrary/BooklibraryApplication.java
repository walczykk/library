package com.booklibrary.booklibrary;

import com.booklibrary.booklibrary.model.Author;
import com.booklibrary.booklibrary.model.Book;
import com.booklibrary.booklibrary.model.PublishingHouse;
import com.booklibrary.booklibrary.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class BooklibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooklibraryApplication.class, args);
	}

	@Bean
	CommandLineRunner run(BookRepository bookRepository) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				bookRepository.save(new Book(null, "Java 10",
						new Author(null, "Józef", "Cieślak", LocalDate.of(2024, 1, 1)),
						new PublishingHouse(null, "Wydawnictwo Stołeczki", "Poznań", "Józef Płotek"), LocalDate.now(), "Przygodowa"));
				bookRepository.save(new Book(null, "Ciemny Straszęcin",
						new Author(null, "Franek", "Golas", LocalDate.of(2022, 10, 2)),
						new PublishingHouse(null, "Wydawnictwo Kamyczki", "Kraków", "Kleofas Płotek"), LocalDate.now(), "Horror"));
				bookRepository.save(new Book(null, "Interstellar",
						new Author(null, "Adam", "Kantor", LocalDate.of(2023, 1, 1)),
						new PublishingHouse(null, "Wydawnictwo Stołeczki", "Reszów", "Olaf Skrzeczyk"), LocalDate.now(), "Science fiction"));
			}
		};
	}
}
