package com.example.desafiozup.services;

public class ComicDataWrapper {
		
	private ComicDataContainer data;
	
	public ComicDataWrapper() {}
	
  public ComicDataWrapper(ComicDataContainer data) {
		super();
		this.data = data;
	}

	public ComicDataContainer getData() {
		return data;
	}

	public void setData(ComicDataContainer data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ComicDataWrapper [data=" + data + "]";
	}

	

	
	

}
