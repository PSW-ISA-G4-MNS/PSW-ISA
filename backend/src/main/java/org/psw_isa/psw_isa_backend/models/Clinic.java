package org.psw_isa.psw_isa_backend.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Clinic {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

	private Long LocationLat;
	
	private Long LocationLog;
	
	private String name; 
	
	private String address; 
	
	private String description;
	
	
	
	public Clinic() 
	{
	}
	public Clinic(Long LocationLat,Long LocationLog ,String _name, String _address, String description) {
		super();
		
		this.LocationLat=LocationLat;
		
		this.LocationLog=LocationLog;
		
		this.name = _name;
		 
		this.address = _address;
		 
		this.setDescription(description);
		
	}
	public void assign(Clinic other) {

		this.LocationLat=other.getLocationLat();
		
		this.LocationLog=other.getLocationLog();
		
		this.name = other.getName();
		 
		this.address = other.getAddress();
		 
		this.setDescription(other.getDescription());
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
	public void setId(Long newValue) 
	{
		this.id = newValue;
	}
	 
	public Long getId() 
	{
		return this.id;
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
	public Long getLocationLat() {
		return LocationLat;
	}
	public void setLocationLat(Long locationLat) {
		LocationLat = locationLat;
	}
	public Long getLocationLog() {
		return LocationLog;
	}
	public void setLocationLog(Long locationLog) {
		LocationLog = locationLog;
	}

	
}
