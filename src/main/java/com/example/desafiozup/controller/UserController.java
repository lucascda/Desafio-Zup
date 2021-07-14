package com.example.desafiozup.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.desafiozup.exceptions.ResourceNotFoundException;
import com.example.desafiozup.model.Comic;
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
	public ResponseEntity<User> create(@RequestBody @Valid CreateUserRequest request) {
		User user = request.toModel();
		userRepository.save(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(user);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		try {
			Optional<User> user = userRepository.findById(id);
			User myUser = user.get();
			List<Comic> myComicsList = myUser.getComics();
			for(Comic comic: myComicsList) {
				comic.setDiaDesconto(comic.parseIsbnToDay());
				comic.setDescontoAtivo(comic.criaDescontoAtivo());
				if(comic.getDescontoAtivo() == Boolean.TRUE) {
					comic.setPreco(comic.getPreco() - comic.getPreco() * 0.1);
				}
			}
				return ResponseEntity.ok().body(myUser);
		} catch (Exception e) {
			throw new ResourceNotFoundException(id);
			}

	}
}