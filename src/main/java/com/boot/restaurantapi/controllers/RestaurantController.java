package com.boot.restaurantapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.boot.restaurantapi.exceptions.BookingExceptions;
import com.boot.restaurantapi.jsons.RestaurantJson;
import com.boot.restaurantapi.responses.BookingResponse;
import com.boot.restaurantapi.services.IRestaurantService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/booking-restaurant" + "/v1")
public class RestaurantController {

	@Autowired
	IRestaurantService iRestaurantService;

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "restaurant" + "/{" + "restaurantId"
			+ "}", method = RequestMethod.GET, produces = "application/json")
	public BookingResponse<RestaurantJson> getRestaurantById(@PathVariable Long restaurantId) throws BookingExceptions {
		return new BookingResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
				iRestaurantService.getRestaurantById(restaurantId));
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "restaurants", method = RequestMethod.GET, produces = "application/json")
	public BookingResponse<List<RestaurantJson>> getRestaurants() throws BookingExceptions {
		return new BookingResponse<>("Succcess", String.valueOf(HttpStatus.OK), "OK",
				iRestaurantService.getRestaurants());
	}

}
