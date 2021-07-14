package com.example.desafiozup.services;

import java.util.ArrayList;

public class CreatorList {
	

	private ArrayList<CreatorSumary> items = new ArrayList<>();

	public CreatorList() {
		
	}
	
	public CreatorList(ArrayList<CreatorSumary> items) {
		super();
		this.items = items;
	}

	public ArrayList<CreatorSumary> getItems() {
		return items;
	}

	public void setItems(ArrayList<CreatorSumary> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "CreatorList [items=" + items + "]";
	}

	
	
	
}
