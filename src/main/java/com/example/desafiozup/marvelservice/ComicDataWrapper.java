package com.example.desafiozup.marvelservice;

public class ComicDataWrapper {
		
private ComicDataContainer data;
	
public ComicDataWrapper() { }
	
  public ComicDataWrapper(ComicDataContainer data) {
		super();
		this.data = data;
	}

public ComicDataContainer getData() {
	return data;
}

public ComicResponse getComicResponse() {
	return data.getResults();
}
	
	@Override
	public String toString() {
		return "ComicDataWrapper [data=" + data + "]";
	}

	

	
	

}
