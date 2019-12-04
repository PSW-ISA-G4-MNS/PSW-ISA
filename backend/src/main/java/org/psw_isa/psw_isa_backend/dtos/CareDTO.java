package org.psw_isa.psw_isa_backend.dtos;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class CareDTO {

	
	private Long doctorId; 
	
	private Long roomId; 
	
	private LocalDateTime startTime; 
	
	private LocalDateTime endTime;

	private Double price;


	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
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

	public CareDTO(Long doctorId, Long roomId, LocalDateTime startTime, LocalDateTime endTime, Double price) {
		super();
		this.doctorId = doctorId;
		this.roomId = roomId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.price = price;
	} 
	
	public CareDTO() {
		
	}


	public Double getPrice() {
		return price; 
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
}
