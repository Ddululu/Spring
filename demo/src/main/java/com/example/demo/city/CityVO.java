package com.example.demo.city;

public class CityVO {
	private String countryCode;
	private String district;
	private int id;
	private String name;
	private int population;
	
	public CityVO() {
		// TODO Auto-generated constructor stub
	}
	
	public CityVO(int id, String name, String countryCode, String district, int population) {
		this.id = id;
		this.name = name;
		this.countryCode = countryCode;
		this.district = district;
		this.population = population;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return "City [countryCode=" + countryCode + ", district=" + district + ", id=" + id + ", name=" + name
				+ ", population=" + population + "]";
	}
	
}
