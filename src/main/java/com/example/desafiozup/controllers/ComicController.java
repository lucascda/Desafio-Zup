package com.example.desafiozup.controllers;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.desafiozup.exceptions.ResourceNotFoundException;
import com.example.desafiozup.marvelservice.MarvelApiClientService;
import com.example.desafiozup.marvelservice.reponsedata.ComicDataWrapper;
import com.example.desafiozup.models.Comic;
import com.example.desafiozup.models.User;
import com.example.desafiozup.repositories.ComicRepository;
import com.example.desafiozup.repositories.UserRepository;

@RestController
@RequestMapping(value = "/v1/comics")
public class ComicController {
	
	@Autowired
	private MarvelApiClientService service;
	@Autowired
	private ComicRepository comicRepository;
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping(value = "/{ComicId}/{UserId}")
	@Transactional
	public ResponseEntity<Comic> create(@PathVariable Integer ComicId, @PathVariable Long UserId){
		
			Optional<User> userOptional = userRepository.findById(UserId);
			if(userOptional.isEmpty()) {
				throw new ResourceNotFoundException(UserId);
			}
			ComicDataWrapper apiResponse = service.searchComic(ComicId);
			System.out.println(apiResponse);
			if(apiResponse == null) {
				throw new ResourceNotFoundException(ComicId);
			}
			User myUser = userOptional.get();			
			Comic myComic = apiResponse.getComicResponse().toModel(myUser);
			comicRepository.save(myComic);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(myComic.getId()).toUri();
			
			return ResponseEntity.created(uri).body(myComic);					
	
}
	
}
