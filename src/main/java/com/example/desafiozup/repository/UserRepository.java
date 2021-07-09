package com.example.desafiozup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.desafiozup.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
