package com.example.sbreactbootcamp.books.controllers;

import com.example.sbreactbootcamp.books.model.Genres;
import com.example.sbreactbootcamp.books.repositories.IGenresRepository;
import com.example.sbreactbootcamp.users.model.User;
import com.example.sbreactbootcamp.utils.response.R;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.testng.IResultMap;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/genres")
@Tag(name = "default")
@CrossOrigin("*")
public class GenresController {

    private static final Logger logger= LoggerFactory.getLogger(GenresController.class);

    @Autowired
    IGenresRepository genresRepository;
     private  R<Genres>  _genres = new  R<Genres>();
    @GetMapping("")
    public R<List<Genres>> findGenresAll(){
        List<Genres> genresList = null;

        try{
            genresList = genresRepository.findAll();
        }catch (Exception e){
            logger.error("Find the genres list fails" + e.getMessage());
        }

        return new R<List<Genres>>().success().data(genresList);
    }
    @Operation(summary = "Retrieve an existing genres")
    @GetMapping("/{name}")
    public  R<Genres> findGenresByName (@Parameter(description = "Find Genres By Id")@PathVariable String bookName ) {
        var  result =genresRepository.findById(bookName);


        if (result.isEmpty()) {
            logger.error("Find the genres by id fails" );
        }
        return new R<Genres>().success().data(result.get());


    }
    @Operation(summary = "Retrieve an existing genres")
    @GetMapping("/{Id}")
    public  R<Genres> findGenresById (@Parameter(description = "Find Genres By Id")@PathVariable String Id ) {
        var  result =genresRepository.findById(Id);


        if (result.isEmpty()) {
            logger.error("Find the genres by id fails" );
        }
        return new R<Genres>().success().data(result.get());


    }
    @Operation(summary = "Creates a new genres")
    @PostMapping
    public R<Genres> addUser(@RequestBody Genres genres){
        try{
            genresRepository.save(genres);
        }catch (Exception e){
            logger.error("Gennres a new user fails:" +e.getMessage());
        }

        return new R<Genres>().success();
    }

    @Operation(summary = "Update an existing genres")
    @PutMapping
    public R<Genres> updateUser(@Parameter(description="Update an existing genres.") @RequestBody Genres genres){
        try{

         genresRepository.save(genres);
        }catch (Exception e){
            logger.error("Update an existing user fails:" +e.getMessage());
        }

        return new R<Genres>().success();
    } //@Transactional(readOnly = true)
    @Operation(summary = "Retrieve an existing genres")
    @DeleteMapping(value = "/{id}")
    //@RequestMapping(method = RequestMethod.DELETE)
    public R<Genres> deleteGenres(@Parameter(description = "Delete an existing genres.") @PathVariable final String Id){

        try{
            genresRepository.deleteById(Id);
        }catch(Exception e){
            logger.error("Delete an existing user fails:" +e.getMessage());
        }

        return new R<Genres>().success();
    }
}
