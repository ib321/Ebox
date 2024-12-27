package com.springboot.domain;

public class Hall {
	
	private Long id;
	private String name;
	private String city;
	private String owner;
	private Double costPerDay;
	
	
	public Hall() {
		super();
	}
	
	
	public Hall(Long id, String name, String city, String owner, Double costPerDay) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.owner = owner;
		this.costPerDay = costPerDay;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getOwner() {
		return owner;
	}


	public void setOwner(String owner) {
		this.owner = owner;
	}


	public Double getCostPerDay() {
		return costPerDay;
	}


	public void setCostPerDay(Double costPerDay) {
		this.costPerDay = costPerDay;
	}
	
	

}
