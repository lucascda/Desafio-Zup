package com.example.desafiozup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.desafiozup.model.Comic;

@Repository
public interface ComicRepository extends JpaRepository<Comic, Long>{

}
