package com.MovieCatalog.Model;

public class CatalogItem {
	
	String Desc;
	String name;
	String rating;
	
	
	
	
	public CatalogItem(String desc, String name, String string) {
		super();
		Desc = desc;
		this.name = name;
		this.rating = string;
	}
	public String getDesc() {
		return Desc;
	}
	public void setDesc(String desc) {
		Desc = desc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}

}
