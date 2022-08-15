package com.example.sbreactbootcamp.books.repositories;

import com.example.sbreactbootcamp.books.model.Genres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGenresRepository extends JpaRepository<Genres, String> {
}
