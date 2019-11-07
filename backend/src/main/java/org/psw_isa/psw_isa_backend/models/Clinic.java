package org.psw_isa.psw_isa_backend.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.time.*;


@Entity
public class Clinic {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

	
	
	private String name; 
	
	
	private String address; 
	
	
	private Long locationLat; 
	
	
	private Long locationLon; 
	
	
	private Integer ambulanceCarCount; 
	

	public Clinic() 
	{
	}
	public Clinic(String _name, String _address, Long _locationLat, Long _locationLon, Integer _ambulanceCarCount) {
		super();
		 
		this.name = _name;
		 
		this.address = _address;
		 
		this.locationLat = _locationLat;
		 
		this.locationLon = _locationLon;
		 
		this.ambulanceCarCount = _ambulanceCarCount;
		
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
	 
	public Long getLocationLat() 
	{
		return this.locationLat;
	}

	public void setLocationLat(Long newValue) 
	{
		this.locationLat = newValue;
	}
	 
	public Long getLocationLon() 
	{
		return this.locationLon;
	}

	public void setLocationLon(Long newValue) 
	{
		this.locationLon = newValue;
	}
	 
	public Integer getAmbulanceCarCount() 
	{
		return this.ambulanceCarCount;
	}

	public void setAmbulanceCarCount(Integer newValue) 
	{
		this.ambulanceCarCount = newValue;
	}
	
}