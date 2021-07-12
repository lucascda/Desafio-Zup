package com.example.desafiozup.services;

import javax.persistence.Column;
import javax.persistence.Embeddable;


public class CreatorSumary {
		
	private String name;
	
	public CreatorSumary() {
		
	}

	public CreatorSumary(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CreatorSumary [name=" + name + "]";
	}
	
	
}
