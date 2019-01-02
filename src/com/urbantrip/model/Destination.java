package com.urbantrip.model;

public class Destination {
	int idDestination;
	int idTour;
	String name;
	int idImage;
	
	public Destination(int idDestination, int idTour, String name, int idImage) {
		super();
		this.idDestination = idDestination;
		this.idTour = idTour;
		this.name = name;
		this.idImage = idImage;
	}
	
	public Destination(int idTour, String name, int idImage) {
		super();
		this.idTour = idTour;
		this.name = name;
		this.idImage = idImage;
	}

	public int getIdDestination() {
		return idDestination;
	}
	public void setIdDestination(int idDestination) {
		this.idDestination = idDestination;
	}
	public int getIdTour() {
		return idTour;
	}
	public void setIdTour(int idTour) {
		this.idTour = idTour;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getIdImage() {
		return idImage;
	}

	public void setIdImage(int idImage) {
		this.idImage = idImage;
	}
}
