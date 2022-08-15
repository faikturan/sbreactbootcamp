package com.example.sbreactbootcamp.books.repositories;

import com.example.sbreactbootcamp.books.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBooksRepository extends JpaRepository<Books, String> {
}
