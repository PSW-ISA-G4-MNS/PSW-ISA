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

	
	
	private String name; 
	
	private String address; 
	
	private String description;
	
	
	
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

	
}