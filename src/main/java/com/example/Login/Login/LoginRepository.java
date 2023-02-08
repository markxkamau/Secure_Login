package com.example.Login.Login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginRepository extends JpaRepository<UserLogin, Long> {
    UserLogin findByEmail(String username);
}
