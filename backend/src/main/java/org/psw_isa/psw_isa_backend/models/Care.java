package org.psw_isa.psw_isa_backend.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Care {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne
    @JoinColumn
	private Doctor doctor; 
	
	@ManyToOne
    @JoinColumn
	private Patient patient; 
	
	@ManyToOne
    @JoinColumn
	private Room room; 
	
	
	
	
	private LocalDateTime startTime; 
	
	private LocalDateTime endTime;

	private Double price;

	private String comment;

	@OneToOne
	private Diagnosis diagnosis;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public Care(Long id, Doctor doctor, Patient patient, Room room, LocalDateTime startTime, LocalDateTime endTime, Double price) {
		super();
		this.id = id;
		this.doctor = doctor;
		this.patient = patient;
		this.room = room;
		this.startTime = startTime;
		this.endTime = endTime;
		this.price = price;
	} 
	
	public Care() {
		
	}


	public Double getPrice() {
		return price; 
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getComment() {
		return comment; 
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Diagnosis getDiagnosis() {
		return diagnosis; 
	}

	public void setDiagnosis(Diagnosis diagnosis) {
		this.diagnosis = diagnosis;
	}
	
}
