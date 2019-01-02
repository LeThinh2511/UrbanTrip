package com.urbantrip.model;

import java.sql.ResultSet;

public class Tour {
	String idTour;
	String name;
	String description;
	Double price;
	String type;
	String imagePath;
	Boolean isDeleted;
	
	public Tour(String idTour, String name, String description, Double price, String type, String imagePath,
			Boolean isDeleted) {
		super();
		this.idTour = idTour;
		this.name = name;
		this.description = description;
		this.price = price;
		this.type = type;
		this.imagePath = imagePath;
		this.isDeleted = isDeleted;
	}
	
	
	
	public Tour(String name, String description, Double tourPrice, String type) {
		super();
		this.name = name;
		this.description = description;
		this.price = tourPrice;
		this.type = type;
	}



	public String getIdTour() {
		return idTour;
	}
 	
	public void setIdTour(String idTour) {
		this.idTour = idTour;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getImagePath() {
		return imagePath;
	}
	
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	} 

}
