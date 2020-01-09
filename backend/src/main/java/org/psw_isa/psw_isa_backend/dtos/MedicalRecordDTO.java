package org.psw_isa.psw_isa_backend.dtos;

import java.util.ArrayList;

import org.psw_isa.psw_isa_backend.models.Care;


public class MedicalRecordDTO {

	
	private Long patientId;
	
	
	private String height;
	
	private String width;
	
	private String bloodType;
	
	private String diopter;
	
	
	


private MedicalRecordDTO() {
		
	}
	
	private MedicalRecordDTO(Long patientId, String width, String height, String bloodType,String diopter) {
		super();
		this.patientId=patientId;
		this.width=width;
		this.height=height;
		this.bloodType=bloodType;
		this.diopter=diopter;
		
	}
	
	public Long getPatientId() {
		return patientId;
	}


	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}


	public String getHeight() {
		return height;
	}


	public void setHeight(String height) {
		this.height = height;
	}


	public String getWidth() {
		return width;
	}


	public void setWidth(String width) {
		this.width = width;
	}


	public String getBloodType() {
		return bloodType;
	}


	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}


	public String getDiopter() {
		return diopter;
	}


	public void setDiopter(String diopter) {
		this.diopter = diopter;
	}



}
