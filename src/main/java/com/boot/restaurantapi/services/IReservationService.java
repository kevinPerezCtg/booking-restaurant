package com.boot.restaurantapi.services;

import com.boot.restaurantapi.exceptions.BookingExceptions;
import com.boot.restaurantapi.jsons.CreateReservationJson;
import com.boot.restaurantapi.jsons.ReservationJson;

public interface IReservationService {
	
	ReservationJson getReservation(Long id) throws BookingExceptions;
	String creteReservation(CreateReservationJson createReservationJson) throws BookingExceptions;
	String deleteReservation(String locator) throws BookingExceptions;

}
