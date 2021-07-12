package com.example.desafiozup.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.desafiozup.model.Comic;
import com.example.desafiozup.repository.ComicRepository;
import com.example.desafiozup.services.ComicDataWrapper;
import com.example.desafiozup.services.ComicResponse;
import com.example.desafiozup.services.CreatorSumary;
import com.example.desafiozup.services.MarvelApiClientService;

@RestController
@RequestMapping(value = "/v1/comics")
public class ComicController {
	
	@Autowired
	private MarvelApiClientService service;
	
	@Autowired
	private ComicRepository comicRepository;
	
	@PostMapping(value = "/{ComicId}")
	@Transactional
	public ResponseEntity<Comic> create(@PathVariable String ComicId){
		
		ComicDataWrapper comic = service.searchComic(ComicId);
		Map<String, Object> map = new HashMap<>();
		ComicResponse myResponse = comic.getData().getResults().get(0);
		Comic myComic = new Comic();
		
		map.put("comicId", myResponse.getId());
		map.put("title", myResponse.getTitle());
		map.put("description", myResponse.getDescription());
		map.put("isbn",myResponse.getIsbn());
		map.put("price", myResponse.getPrices().get(0).getPrice());
		map.put("autores", myResponse.getCreators().getItems());
		myComic.setComicId((Integer) map.get("comicId"));
		myComic.setTitulo((String) map.get("title"));
		myComic.setDescricao((String) map.get("description"));
		myComic.setIsbn((String) map.get("isbn"));
		myComic.setPreco((Double) map.get("price"));
		List<CreatorSumary> autores = (List<CreatorSumary>)map.get("autores");		
		for(CreatorSumary autor: autores) {
			myComic.addAutor(autor.getName());			
		}
				
		comicRepository.save(myComic);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(myComic.getId()).toUri();
		return ResponseEntity.created(uri).body(myComic);
	}
	
	

}
