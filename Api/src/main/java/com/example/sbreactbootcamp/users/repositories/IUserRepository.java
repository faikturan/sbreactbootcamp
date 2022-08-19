package com.example.sbreactbootcamp.users.repositories;

import com.example.sbreactbootcamp.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, String> {


}
