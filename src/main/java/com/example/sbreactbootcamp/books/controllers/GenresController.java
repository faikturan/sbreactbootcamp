package com.example.sbreactbootcamp.books.controllers;

import com.example.sbreactbootcamp.books.model.Genres;
import com.example.sbreactbootcamp.books.repositories.IGenresRepository;
import com.example.sbreactbootcamp.utils.response.R;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/genres")
@Tag(name = "default")
@CrossOrigin("*")
public class GenresController {

    private static final Logger logger= LoggerFactory.getLogger(GenresController.class);

    @Autowired
    IGenresRepository genresRepository;

    @GetMapping("")
    public R<List<Genres>> findGenres(){
        List<Genres> genresList = null;

        try{
            genresList = genresRepository.findAll();
        }catch (Exception e){
            logger.error("Find the genres list fails" + e.getMessage());
        }

        return new R<List<Genres>>().success().data(genresList);
    }

}
