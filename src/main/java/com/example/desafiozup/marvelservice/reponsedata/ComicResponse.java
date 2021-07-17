package com.example.desafiozup.marvelservice.reponsedata;

import java.util.ArrayList;
import java.util.List;

import com.example.desafiozup.models.Comic;
import com.example.desafiozup.models.User;

public class ComicResponse {
	
	private Integer id;
	private String title;
	private String isbn;
	private String description;
	private List<ComicPrice> prices;
	private CreatorList creators;
	
	public ComicResponse() {
		
	}

	public ComicResponse(Integer id, String title, String isbn, String description, ArrayList<ComicPrice> prices, CreatorList creators) {
		super();
		this.id = id;
		this.title = title;
		this.isbn = isbn;
		this.description = description;
		this.prices = prices;
		this.creators = creators;
	}

	public Comic toModel(User user) {
		return new Comic(id, title, isbn, description, prices.get(0).getPrice(), creators.getAuthorsName(), user);
	}
	
	public Integer getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getIsbn() {
		return isbn;
	}

	
	public String getDescription() {
		return description;
	}

	
	public List<ComicPrice> getPrices() {
		return prices;
	}

	public CreatorList getCreators() {
		return creators;
	}



	@Override
	public String toString() {
		return "ComicResponse [id=" + id + ", title=" + title + ", isbn=" + isbn + ", description=" + description
				+ ", prices=" + prices + ", creators=" + creators + "]";
	}
	
	
	
	
}
