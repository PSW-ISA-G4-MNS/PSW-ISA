package org.psw_isa.psw_isa_backend.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.time.*;
import java.util.ArrayList;
import java.util.HashMap;


@Entity
public class Clinic {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

	
	
	private String name; 
	
	
	private String address; 
	
	private String description;
	
	private ArrayList<Doctor> doctors;
	
	private ArrayList<Room> rooms;
	
	private HashMap<String,String> prices;

	private ArrayList<String> appointment;
	
	public Clinic() 
	{
	}
	public Clinic(String _name, String _address, String description) {
		super();
		 
		this.name = _name;
		 
		this.address = _address;
		 
		this.setDescription(description);
		
	}
	
	 
	public String getName() 
	{
		return this.name;
	}

	public void setName(String newValue) 
	{
		this.name = newValue;
	}
	 
	public String getAddress() 
	{
		return this.address;
	}

	public void setAddress(String newValue) 
	{
		this.address = newValue;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ArrayList<Doctor> getDoctors() {
		return doctors;
	}
	public void setDoctors(ArrayList<Doctor> doctors) {
		this.doctors = doctors;
	}
	public ArrayList<Room> getRooms() {
		return rooms;
	}
	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}
	public HashMap<String,String> getPrices() {
		return prices;
	}
	public void setPrices(HashMap<String,String> prices) {
		this.prices = prices;
	}
	public ArrayList<String> getAppointment() {
		return appointment;
	}
	public void setAppointment(ArrayList<String> appointment) {
		this.appointment = appointment;
	}
	 
	
}