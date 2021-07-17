package com.example.desafiozup.marvelservice.reponsedata;

import java.util.ArrayList;
import java.util.List;

public class CreatorList {
	

	private List<CreatorSumary> items;

	public CreatorList() {
		
	}
	
	public CreatorList(List<CreatorSumary> items) {
		super();
		this.items = items;
	}

	public List<CreatorSumary> getItems() {
		return items;
	}

	public List<String> getAuthorsName(){
		List<String> authors = new ArrayList<String>();
		for(CreatorSumary autor : items) {
			authors.add(autor.getName());
		}
		
		return authors;
	}

	@Override
	public String toString() {
		return "CreatorList [items=" + items + "]";
	}

	
	
	
}
