package com.example.desafiozup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafiozup.services.Comic;
import com.example.desafiozup.services.ComicDataWrapper;
import com.example.desafiozup.services.MarvelApiClientService;

@RestController
@RequestMapping(value = "/v1/comics")
public class ComicController {
	
	@Autowired
	private MarvelApiClientService service;
	
	@GetMapping(value = "/{ComicId}")
	public ResponseEntity<ComicDataWrapper> getComicById(@PathVariable String ComicId){
		
		ComicDataWrapper comic = service.searchComic(ComicId);
		
		return ResponseEntity.ok().body(comic);
		
	}
}
