package com.example.desafiozup.controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.desafiozup.model.User;
import com.example.desafiozup.repository.ComicRepository;
import com.example.desafiozup.repository.UserRepository;
import com.example.desafiozup.request.CreateUserRequest;

@RestController
@RequestMapping(value = "/v1/users")
public class UserController {
	@Autowired
	UserRepository userRepository;

	@Autowired
	ComicRepository comicRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<User> create(@RequestBody @Valid CreateUserRequest request){
		User user = request.toModel();
			userRepository.save(user);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();			
			return ResponseEntity.created(uri).body(user);		
	}
	
}
