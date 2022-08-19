package com.example.sbreactbootcamp.books.controllers;

import com.example.sbreactbootcamp.books.model.Books;

import com.example.sbreactbootcamp.books.repositories.IBooksRepository;
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
@RequestMapping("/api/books")
@Tag(name = "default")
@CrossOrigin("*")
public class BooksController {

    private static final Logger logger= LoggerFactory.getLogger(BooksController.class);

    @Autowired
    IBooksRepository booksRepository;

    @Operation(summary ="Find the Book list")
    @GetMapping("")
    @ResponseBody
    public R<List<Books>> findBooks(){
        List<Books> booksList = null;

        try{
            booksList = booksRepository.findAll();
        }catch (Exception e){
            logger.error("Find the Book list fails: " +e.getMessage());
        }

        return new R<List<Books>>().success().data(booksList);
    }
    @Operation(summary = "Retrieve an existing book")
    @GetMapping("/{name}")
    public  R<Books> findBookByName (@Parameter(description = "Find Book By BookName")@PathVariable String bookName ) {
        var  result =booksRepository.findById(bookName);


        if (result.isEmpty()) {
            logger.error("Find the book by id fails" );
        }
        return new R<Books>().success().data(result.get());


    }
    @Operation(summary = "Retrieve an existing book")
    @GetMapping("/{Id}")
    public R<Books>findBookById (@Parameter(description = "Find book By Id")@PathVariable String Id ) {
        var  result =booksRepository.findById(Id);


        if (result.isEmpty()) {
            logger.error("Find the book by id fails" );
        }
        return new R<Books>().success().data(result.get());


    }
    @Operation(summary = "Creates a new book")
    @PostMapping
    public R<Books>addBook(@RequestBody Books book){
        try{
            booksRepository.save(book);
        }catch (Exception e){
            logger.error("Book create is fail :" +e.getMessage());
        }

        return new R<Books>().success();
    }

    @Operation(summary = "Update an existing book")
    @PutMapping
    public R<Books> updateBook(@Parameter(description="Update an existing book.") @RequestBody Books books){
        try{

            booksRepository.save(books);
        }catch (Exception e){
            logger.error("Update an existing books fails:" +e.getMessage());
        }

        return new R<Books>().success();
    } //@Transactional(readOnly = true)
    @Operation(summary = "Retrieve an existing bok")
    @DeleteMapping(value = "/{id}")
    //@RequestMapping(method = RequestMethod.DELETE)
    public R<Books> deleteBook(@Parameter(description = "Delete an existing book.") @PathVariable final String Id){

        try{
            booksRepository.deleteById(Id);
        }catch(Exception e){
            logger.error("Delete an existing book fails:" +e.getMessage());
        }

        return new R<Books>().success();
    }
}
