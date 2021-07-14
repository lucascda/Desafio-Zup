package com.example.desafiozup.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
@FeignClient(name="marvelService", url = "${marvel.uri}")
public interface MarvelApiClientService {
	
	@RequestMapping(method=RequestMethod.GET,value = "/comics/{ComicId}?ts=1&apikey=${marvel.key}&hash=${marvel.hash}")
	ComicDataWrapper searchComic(@PathVariable(value = "ComicId") String ComicId);
}
