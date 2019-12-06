package org.psw_isa.psw_isa_backend.service;

import org.psw_isa.psw_isa_backend.models.Clinic;
import org.psw_isa.psw_isa_backend.repository.ClinicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.psw_isa.psw_isa_backend.service.CareService;
import org.psw_isa.psw_isa_backend.models.Care;
import org.psw_isa.psw_isa_backend.service.DoctorService;
import org.psw_isa.psw_isa_backend.service.ClinicRatingService;
import org.psw_isa.psw_isa_backend.service.DoctorRatingService;
import org.psw_isa.psw_isa_backend.models.Doctor;
import org.psw_isa.psw_isa_backend.dtos.ClinicReportDTO;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

@Service
public class ClinicService {

	@Autowired 
	ClinicRepository clinicRepository;
	
	@Autowired
	CareService careService;
	
	@Autowired
	DoctorService doctorService;
	
	@Autowired
	DoctorRatingService doctorRatingService;
	
	@Autowired
	ClinicRatingService clinicRatingService;

	public Clinic save(Clinic clinic) {
		return clinicRepository.save(clinic);
	}

	public Clinic findOneByid(Long id) {
		return clinicRepository.findOneByid(id);
	}

	public List<Clinic> findAll() {
		return clinicRepository.findAll();
	}

	public List<Care> findCaresForClinic(Clinic clinic) {
		List<Care> cares = new ArrayList<Care>();
		for (Care care : careService.findAll()) {
			if (care.getRoom() != null && care.getRoom().getClinic() != null && care.getRoom().getClinic().getId() == clinic.getId()) {
				cares.add(care);
			}
		}
		return cares;
	}

	public Double getRevenue(Clinic clinic, LocalDateTime start, LocalDateTime end) {
		Double sum = 0.0;
		for (Care care : this.findCaresForClinic(clinic)) {
			if (care.getStartTime().isAfter(start) && care.getEndTime().isBefore(end)) {
				sum += care.getPrice();
			}
		}
		return sum;
	}

	public ClinicReportDTO getReport(Clinic clinic, LocalDateTime start, LocalDateTime end) {
		int dayCount = (int) this.findCaresForClinic(clinic).stream().filter(x -> x.getStartTime().isAfter(LocalDateTime.now().minusDays(1))).count();
		int weekCount = (int) this.findCaresForClinic(clinic).stream().filter(x -> x.getStartTime().isAfter(LocalDateTime.now().minusDays(7))).count();
		int monthCount = (int) this.findCaresForClinic(clinic).stream().filter(x -> x.getStartTime().isAfter(LocalDateTime.now().minusDays(30))).count();
		double averageRate = clinicRatingService.getClinicAverage(clinic);
		Map<Long, Double> doctorRatings = new TreeMap<Long, Double>();
		List<Doctor> doctors = doctorService.findAllByClinic(clinic);
		for (Doctor doctor : doctors) {
			doctorRatings.put(doctor.getId(), doctorRatingService.getDoctorAverage(doctor));
		}
		return new ClinicReportDTO(dayCount, weekCount, monthCount, averageRate, doctorRatings, this.getRevenue(clinic, start, end));

	}



}
