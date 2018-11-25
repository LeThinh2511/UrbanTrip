package com.urbantrip.model;

public class Destination {
	String idDestination;
	String idTour;
	String name;
	String imagePath;
	
	public Destination(String idDestination, String idTour, String name, String imagePath) {
		super();
		this.idDestination = idDestination;
		this.idTour = idTour;
		this.name = name;
		this.imagePath = imagePath;
	}
	
	public String getIdDestination() {
		return idDestination;
	}
	public void setIdDestination(String idDestination) {
		this.idDestination = idDestination;
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
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
}
