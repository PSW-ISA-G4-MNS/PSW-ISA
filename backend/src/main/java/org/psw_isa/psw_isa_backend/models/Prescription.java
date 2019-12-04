package org.psw_isa.psw_isa_backend.models;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Prescription {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long id;
	
	private ArrayList<Medicine> medicines;

	
	public Prescription() {
		
	}
	
	public Prescription(Long id, ArrayList<Medicine> lista) {
		super();
		this.id=id;
		this.medicines=lista;
		
	}
	public void setId(Long newValue) 
	{
		this.id = newValue;
	}
	 
	public Long getId() 
	{
		return this.id;
	}
	
	
	public ArrayList<Medicine> getMedicines() {
		return medicines;
	}

	public void setMedicines(ArrayList<Medicine> medicines) {
		this.medicines = medicines;
	}
	
	public void addMedicine(Medicine medicine) {
		this.medicines.add(medicine);
	}
	
	public void removeMedicine(Medicine medicine) {
		this.medicines.remove(medicine);
	}
}
