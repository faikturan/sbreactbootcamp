package com.example.sbreactbootcamp.users.controllers;

import com.example.sbreactbootcamp.users.model.User;
import com.example.sbreactbootcamp.users.repositories.IUserRepository;
import com.example.sbreactbootcamp.utils.response.R;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Tag(name="default")
@CrossOrigin("*")
public class UserController {

    private static final Logger logger =  LoggerFactory.getLogger(UserController.class);

    @Autowired
    IUserRepository userRepository;

    @Operation(summary = "Creates a new user")
    @PostMapping
    public R<User> addUser(@RequestBody User user){
        try{
            userRepository.save(user);
        }catch (Exception e){
            logger.error("Creates a new user fails:" +e.getMessage());
        }

        return new R<User>().success();
    }

    @Operation(summary = "Update an existing user")
    @PutMapping
    public R<User> updateUser(@Parameter(description="Update an existing user.") @RequestBody User user){
        try{
            userRepository.save(user);
        }catch (Exception e){
            logger.error("Update an existing user fails:" +e.getMessage());
        }

        return new R<User>().success();
    }

    @Operation(summary = "Retrieve an existing user")
    @GetMapping("/{email}")
    public R<User> findUserByEmail(@Parameter(description = "A user's email")@PathVariable String email){
        User user = null;
        try{
            user = userRepository.findById(email).orElse(new User());
        }catch(Exception e){
            logger.error("Retrieve an existing user fails:" +e.getMessage());
        }

        return new R<User>().success().data(user);
    }

    //@Transactional(readOnly = true)
    @Operation(summary = "Retrieve an existing user")
    @DeleteMapping(value = "/{email}")
    //@RequestMapping(method = RequestMethod.DELETE)
    public R<User> deleteUser(@Parameter(description = "Delete an existing user.") @PathVariable final String email){

        try{
              userRepository.deleteById(email);
        }catch(Exception e){
            logger.error("Delete an existing user fails:" +e.getMessage());
        }

        return new R<User>().success();
    }

    @Operation(summary = "Find the user list")
    @GetMapping("")
    @ResponseBody
    public R<List<User>> findUsers(){
        List<User> userList = null;

        try{
            userList = userRepository.findAll();
        }catch (Exception e){
            logger.error("Find the user list fails:" +e.getMessage());
        }

        return new R<List<User>>().success().data(userList);
    }








}
