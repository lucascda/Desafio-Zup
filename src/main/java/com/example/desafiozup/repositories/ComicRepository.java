package com.example.desafiozup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.desafiozup.models.Comic;

@Repository
public interface ComicRepository extends JpaRepository<Comic, Long>{

}
