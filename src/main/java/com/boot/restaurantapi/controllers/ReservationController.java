package com.boot.restaurantapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.boot.restaurantapi.exceptions.BookingExceptions;
import com.boot.restaurantapi.jsons.CreateReservationJson;
import com.boot.restaurantapi.responses.BookingResponse;
import com.boot.restaurantapi.services.IReservationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/booking-restaurant" + "/v1")
public class ReservationController {

	@Autowired
	IReservationService iReservationService;

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "reservation", method = RequestMethod.POST, produces = "application/json")
	public BookingResponse<String> createReservation(@RequestBody CreateReservationJson createReservationJson)
			throws BookingExceptions{
		return new BookingResponse<>("Sucess", String.valueOf(HttpStatus.OK), "OK",
				iReservationService.creteReservation(createReservationJson));
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/deleteReservation", method = RequestMethod.DELETE, produces = "application/json")
	public BookingResponse<String> deleteReservation(@RequestParam String locator)
			throws BookingExceptions{
		return new BookingResponse<>("Sucess", String.valueOf(HttpStatus.OK), "OK",
				iReservationService.deleteReservation(locator));
	}
}
