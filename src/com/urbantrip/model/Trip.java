package com.urbantrip.model;

public class Trip {

	int id;
	String touristName;
	String numberOfParticipants;
	String nationality;
	String email;
	String phone;
	String status;
	String hotelAddress;
	int id_tour;
	String message;
	
	
	
	public Trip(String touristName, String numberOfParticipants, String nationality, String email, String phone,
			String hotelAddress, int id_tour, String message) {
		super();
		this.touristName = touristName;
		this.numberOfParticipants = numberOfParticipants;
		this.nationality = nationality;
		this.email = email;
		this.phone = phone;
		this.hotelAddress = hotelAddress;
		this.id_tour = id_tour;
		this.message = message;
	}
	public Trip(int id, String touristName, String numberOfParticipants, String nationality, String email, String phone,
			String status, String hotelAddress, int id_tour, String message) {
		super();
		this.id = id;
		this.touristName = touristName;
		this.numberOfParticipants = numberOfParticipants;
		this.nationality = nationality;
		this.email = email;
		this.phone = phone;
		this.status = status;
		this.hotelAddress = hotelAddress;
		this.id_tour = id_tour;
		this.message = message;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTouristName() {
		return touristName;
	}
	public void setTouristName(String touristName) {
		this.touristName = touristName;
	}
	public String getNumberOfParticipants() {
		return numberOfParticipants;
	}
	public void setNumberOfParticipants(String numberOfParticipants) {
		this.numberOfParticipants = numberOfParticipants;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getHotelAddress() {
		return hotelAddress;
	}
	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}
	public int getId_tour() {
		return id_tour;
	}
	public void setId_tour(int id_tour) {
		this.id_tour = id_tour;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
