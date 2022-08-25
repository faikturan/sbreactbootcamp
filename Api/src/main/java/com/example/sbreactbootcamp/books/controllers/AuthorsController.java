package com.example.sbreactbootcamp.books.controllers;


import com.example.sbreactbootcamp.books.model.Authors;
import com.example.sbreactbootcamp.books.model.Genres;
import com.example.sbreactbootcamp.books.repositories.IAuthorsRepository;
import com.example.sbreactbootcamp.utils.response.R;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@Tag(name = "default")
@CrossOrigin("*")
public class AuthorsController {
    private static final Logger logger= LoggerFactory.getLogger(AuthorsController.class);

    @Autowired
    IAuthorsRepository authorsRepository;

    @Operation(summary ="Find the Author list")
    @GetMapping(value="")
    @ResponseBody
    public R<List<Authors>> findAuthors(){
        List<Authors> authorsList = null;

        try{
            authorsList = authorsRepository.findAll();
        }catch (Exception e){
            logger.error("Find the Authors list fails: " +e.getMessage());
        }
        return new R<List<Authors>>().success().data(authorsList);
    }


    @Operation(summary = "Retrieve an existing authors")
    @GetMapping(value="/{Id}")
    public  R<Authors> findAuthorsById (@Parameter(description = "Find authors By Id")@PathVariable String Id ) {
        var  result =authorsRepository.findById(Id);


        if (result.isEmpty()) {
            logger.error("Find the authors by id fails" );
        }
        return new R<Authors>().success().data(result.get());


    }
    @Operation(summary = "Creates a new genres")
    @PostMapping
    public  R<Authors> addAuthors(@RequestBody Authors authors){
        try{
            authorsRepository.save(authors);
        }catch (Exception e){
            logger.error("Authors create is  fails:" +e.getMessage());
        }

        return new R<Authors>().success();
    }

    @Operation(summary = "Update an existing authors")
    @PutMapping
    public R<Authors> updateAuthors(@Parameter(description="Update an existing authors.") @RequestBody Authors authors){
        try{
            authorsRepository.save(authors);
        }catch (Exception e){
            logger.error("Update an existing authors fails:" +e.getMessage());
        }

        return new R<Authors>().success();
    } //@Transactional(readOnly = true)
    @Operation(summary = "Retrieve an existing authors")
    @DeleteMapping(value = "/{id}")
    //@RequestMapping(method = RequestMethod.DELETE)
    public R<Authors> deleteAuthors(@Parameter(description = "Delete an existing authors.") @PathVariable final String Id){

        try{
            authorsRepository.deleteById(Id);
        }catch(Exception e){
            logger.error("Delete an existing authors fails:" +e.getMessage());
        }

        return new R<Authors>().success();
    }
}
