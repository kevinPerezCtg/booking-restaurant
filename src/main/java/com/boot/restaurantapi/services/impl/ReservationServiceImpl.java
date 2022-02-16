package com.boot.restaurantapi.services.impl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.restaurantapi.entities.Reservation;
import com.boot.restaurantapi.entities.Restaurant;
import com.boot.restaurantapi.entities.Turn;
import com.boot.restaurantapi.exceptions.BookingExceptions;
import com.boot.restaurantapi.exceptions.InternlServerErrorException;
import com.boot.restaurantapi.exceptions.NotFoundException;
import com.boot.restaurantapi.jsons.CreateReservationJson;
import com.boot.restaurantapi.jsons.ReservationJson;
import com.boot.restaurantapi.repositories.IReservationRepository;
import com.boot.restaurantapi.repositories.IRestaurantRepository;
import com.boot.restaurantapi.repositories.ITurnRepository;
import com.boot.restaurantapi.services.IReservationService;

@Service
public class ReservationServiceImpl implements IReservationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

	@Autowired
	IReservationRepository iReservationRepository;
	@Autowired
	IRestaurantRepository iRestaurantRepository;
	@Autowired
	ITurnRepository iTurnRepository;

	public static final ModelMapper modelMapper = new ModelMapper();

	@Override
	public String deleteReservation(String locator) throws BookingExceptions {
		iReservationRepository.findByLocator(locator)
				.orElseThrow(() -> new NotFoundException("LOCTAOR NOT FOUND", "RESTAURANT NOT FOUND"));
		try {
			iReservationRepository.deleteByLocator(locator);
		} catch (Exception e) {
			LOGGER.error("INTERNSL_SERVER_ERROR" + e);
			throw new InternlServerErrorException("INTERNSL_SERVER_ERROR", "INTERNSL_SERVER_ERROR");
		}

		return "LOCATOR DELETED";
	}

	@Override
	public ReservationJson getReservation(Long id) throws BookingExceptions {
		return modelMapper.map(getReservationEntity(id), ReservationJson.class);
	}	

	@Override
	public String creteReservation(CreateReservationJson createReservationJson) throws BookingExceptions {
		final Restaurant restaurant = iRestaurantRepository.findById(createReservationJson.getRestaurantId())
				.orElseThrow(() -> new NotFoundException("SNOT-401-1", "RESTAURANT NOT FOUND"));

		final Turn turn = iTurnRepository.findById(createReservationJson.getTurnId())
				.orElseThrow(() -> new NotFoundException("SNOT-401-1", "TURN NOT FOUND"));

		String locator = generateLocator(restaurant, createReservationJson);
		final Reservation reservation = new Reservation();
		reservation.setLocator(locator);
		reservation.setPerson(createReservationJson.getPerson());
		reservation.setDate(createReservationJson.getDate());
		reservation.setRestaurant(restaurant);
		reservation.setTurn(turn.getName());

		try {
			iReservationRepository.save(reservation);
		} catch (final Exception e) {
			LOGGER.error("INTERNSL_SERVER_ERROR" + e);
			throw new InternlServerErrorException("INTERNSL_SERVER_ERROR", "INTERNSL_SERVER_ERROR");
		}

		return locator;
	}
	
	private Reservation getReservationEntity(Long id) throws BookingExceptions {
		return iReservationRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("SNOT-401-1", "RESTAURANT NOT FOUND"));
	}

	private String generateLocator(Restaurant restaurantId, CreateReservationJson createReservationJson)
			throws BookingExceptions {
		return restaurantId.getName() + createReservationJson.getTurnId();
	}

}
