package com.booklibrary.booklibrary.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id", nullable = true)
    private Author author;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publishing_house_id", nullable = true)
    private PublishingHouse publishingHouse;

    private LocalDate releaseDate;

    private String genre;

}