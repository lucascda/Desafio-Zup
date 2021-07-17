package com.example.desafiozup.marvelservice.reponsedata;

public class ComicPrice {
	private Double price;
	
	public ComicPrice() {
		
	}
	
	public ComicPrice(Double price) {
		this.price = price;
	}

	public Double getPrice() {
		return price;
	}


	@Override
	public String toString() {
		return "ComicPrice [price=" + price + "]";
	}
	
	
}
