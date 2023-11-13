package com.dev.BankMate.user;

import com.dev.BankMate.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findUserByEmail(String email);
}
