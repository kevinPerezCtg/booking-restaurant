package com.boot.restaurantapi.jsons;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservationJson {

	@JsonProperty("restaurantId")
	private Long restaurantId;

	@JsonProperty("locator")
	private String locator;
	
	@JsonProperty("date")
	private Date date;
	
	@JsonProperty("person")
	private Date person;
	
	@JsonProperty("turnId")
	private Long turnId;

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getLocator() {
		return locator;
	}

	public void setLocator(String locator) {
		this.locator = locator;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getPerson() {
		return person;
	}

	public void setPerson(Date person) {
		this.person = person;
	}

	public Long getTurnId() {
		return turnId;
	}

	public void setTurnId(Long turnId) {
		this.turnId = turnId;
	}
}
