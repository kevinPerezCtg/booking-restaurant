package com.boot.restaurantapi.services;

import java.util.List;

import com.boot.restaurantapi.exceptions.BookingExceptions;
import com.boot.restaurantapi.jsons.RestaurantJson;

public interface IRestaurantService {

	RestaurantJson getRestaurantById(Long id) throws BookingExceptions;
	public List<RestaurantJson> getRestaurants() throws BookingExceptions;
	
}
