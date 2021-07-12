package com.example.desafiozup.services;

import java.util.ArrayList;

public class Comic {
	
	private Integer id;
	private String title;
	private String isbn;
	private String description;
	private ArrayList<ComicPrice> prices = new ArrayList<>();
	private CreatorList creators;
	
	public Comic() {
		
	}

	public Comic(Integer id, String title, String isbn, String description, ArrayList<ComicPrice> prices, CreatorList creators) {
		super();
		this.id = id;
		this.title = title;
		this.isbn = isbn;
		this.description = description;
		this.prices = prices;
		this.creators = creators;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<ComicPrice> getPrices() {
		return prices;
	}

	public CreatorList getCreators() {
		return creators;
	}

	public void setPrices(ArrayList<ComicPrice> prices) {
		this.prices = prices;
	}

	public void setCreators(CreatorList creators) {
		this.creators = creators;
	}
	
	
	
	
}
