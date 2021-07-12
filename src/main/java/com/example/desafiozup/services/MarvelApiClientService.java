package com.example.desafiozup.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@FeignClient(name="marvelService", url = "${marvel.uri}")
public interface MarvelApiClientService {
	
	@RequestMapping(value = "/comics/{ComicId}?ts=1&apikey=${marvel.public.key}&hash=${marvel.hash}")
	ComicDataWrapper searchComic(@PathVariable(value = "ComicId") String ComicId);
}
