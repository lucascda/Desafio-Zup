package com.example.desafiozup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.desafiozup.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}


