package com.example.sbreactbootcamp.books.repositories;

import com.example.sbreactbootcamp.books.model.Authors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthorsRepository extends JpaRepository<Authors, String> {
}
