package org.psw_isa.psw_isa_backend.dtos;

import java.util.List;
import java.util.Map;

public class ClinicReportDTO {
	
	
	private List<Integer> careCountLastDay; 
	
	private List<Integer> careCountLastWeek; 
	
	private List<Integer> careCountLastMonth; 
	
	private Double averageRating; 
	
	private Map<Long, Double> averageRatingByDoctor; 
	
	private Double revenue; 
	
	public ClinicReportDTO() 
	{
	}
	public ClinicReportDTO(List<Integer> _careCountLastDay, List<Integer> _careCountLastWeek, List<Integer> _careCountLastMonth, Double _averageRating, Map<Long, Double> _averageRatingByDoctor, Double _revenue) {
		super();
		 
		this.careCountLastDay = _careCountLastDay;
		 
		this.careCountLastWeek = _careCountLastWeek;
		 
		this.careCountLastMonth = _careCountLastMonth;
		 
		this.averageRating = _averageRating;
		 
		this.averageRatingByDoctor = _averageRatingByDoctor;
		 
		this.revenue = _revenue;
		
	}
	
	 
	public List<Integer> getCareCountLastDay() 
	{
		return this.careCountLastDay;
	}

	public void setCareCountLastDay(List<Integer> newValue) 
	{
		this.careCountLastDay = newValue;
	}
	 
	public List<Integer> getCareCountLastWeek() 
	{
		return this.careCountLastWeek;
	}

	public void setCareCountLastWeek(List<Integer> newValue) 
	{
		this.careCountLastWeek = newValue;
	}
	 
	public List<Integer> getCareCountLastMonth() 
	{
		return this.careCountLastMonth;
	}

	public void setCareCountLastMonth(List<Integer> newValue) 
	{
		this.careCountLastMonth = newValue;
	}
	 
	public Double getAverageRating() 
	{
		return this.averageRating;
	}

	public void setAverageRating(Double newValue) 
	{
		this.averageRating = newValue;
	}
	 
	public Map<Long, Double> getAverageRatingByDoctor() 
	{
		return this.averageRatingByDoctor;
	}

	public void setAverageRatingByDoctor(Map<Long, Double> newValue) 
	{
		this.averageRatingByDoctor = newValue;
	}
	 
	public Double getRevenue() 
	{
		return this.revenue;
	}

	public void setRevenue(Double newValue) 
	{
		this.revenue = newValue;
	}
	
}
