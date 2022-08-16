package com.example.sbreactbootcamp.books.controllers;


import com.example.sbreactbootcamp.books.model.Authors;
import com.example.sbreactbootcamp.books.repositories.IAuthorsRepository;
import com.example.sbreactbootcamp.utils.response.R;
import io.swagger.v3.oas.annotations.Operation;
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
    @GetMapping("")
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

}
