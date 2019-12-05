package org.psw_isa.psw_isa_backend.dtos;

import java.time.LocalDateTime;

import org.psw_isa.psw_isa_backend.models.CareType;
import org.psw_isa.psw_isa_backend.models.Clinic;

public class ClinicFilterDTO {

	private LocalDateTime time;
	private CareType type;
	private Clinic clinic;
	
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public CareType getType() {
		return type;
	}
	public void setType(CareType type) {
		this.type = type;
	}
	
	public Clinic getClinic() {
		return clinic;
	}
	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}
	public ClinicFilterDTO(LocalDateTime time, CareType type) {
		super();
		this.time = time;
		this.type = type;
	}
	
	public ClinicFilterDTO(LocalDateTime time, CareType type, Clinic clinic) {
		super();
		this.time = time;
		this.type = type;
		this.clinic = clinic;
	}
	public ClinicFilterDTO() {

	}
	
}
