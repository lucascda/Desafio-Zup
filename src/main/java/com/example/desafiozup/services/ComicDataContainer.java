package com.example.desafiozup.services;

import java.util.ArrayList;

public class ComicDataContainer {
	
	private ArrayList<Comic> results = new ArrayList<>();
	
	public ComicDataContainer() {
		
	}

	public ComicDataContainer(ArrayList<Comic> results) {
		super();
		this.results = results;
	}

	public ArrayList<Comic> getResults() {
		return results;
	}

	public void setResults(ArrayList<Comic> results) {
		this.results = results;
	}
	
	
	
}
