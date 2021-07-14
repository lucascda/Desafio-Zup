package com.example.desafiozup.marvelservice;

import java.util.ArrayList;

public class ComicDataContainer {
	
	private ArrayList<ComicResponse> results = new ArrayList<>();
	
	public ComicDataContainer() {
		
	}

	public ComicDataContainer(ArrayList<ComicResponse> results) {
		super();
		this.results = results;
	}

	public ComicResponse getResults() {
		return results.get(0);
	}

	

	@Override
	public String toString() {
		return "ComicDataContainer [results=" + results + "]";
	}
	
	
	
}
