package com.example.desafiozup.services;

import java.util.ArrayList;

public class ComicDataContainer {
	
	private ArrayList<ComicResponse> results = new ArrayList<>();
	
	public ComicDataContainer() {
		
	}

	public ComicDataContainer(ArrayList<ComicResponse> results) {
		super();
		this.results = results;
	}

	public ArrayList<ComicResponse> getResults() {
		return results;
	}

	public void setResults(ArrayList<ComicResponse> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "ComicDataContainer [results=" + results + "]";
	}
	
	
	
}
