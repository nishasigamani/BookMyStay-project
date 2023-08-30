package com.example.pro1.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="booking")
public class bmsmodel 
{
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
    private String type;
    private String location;
    private String amenities;
    private String description;
    private String pricerange;
	public String getPricerange() {
		return pricerange;
	}
	public void setPricerange(String pricerange) {
		this.pricerange = pricerange;
	}
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_id",referencedColumnName="id")
	private List<calender>calender;
	public List<calender> getCalender() {
		return calender;
	}
	public void setCalender(List<calender> calender) {
		this.calender = calender;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAmenities() {
		return amenities;
	}
	public void setAmenities(String amenities) {
		this.amenities = amenities;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
