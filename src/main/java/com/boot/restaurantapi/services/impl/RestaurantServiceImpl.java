package com.boot.restaurantapi.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.restaurantapi.entities.Restaurant;
import com.boot.restaurantapi.exceptions.BookingExceptions;
import com.boot.restaurantapi.exceptions.NotFoundException;
import com.boot.restaurantapi.jsons.RestaurantJson;
import com.boot.restaurantapi.repositories.IRestaurantRepository;
import com.boot.restaurantapi.services.IRestaurantService;

@Service
public class RestaurantServiceImpl implements IRestaurantService {

	@Autowired
	IRestaurantRepository iRestaurantRepository;

	public static final ModelMapper modelMapper = new ModelMapper();

	@Override
	public RestaurantJson getRestaurantById(Long id) throws BookingExceptions {
		return modelMapper.map(getRestaurantEntity(id), RestaurantJson.class);
	}

	@Override
	public List<RestaurantJson> getRestaurants() throws BookingExceptions {
		final List<Restaurant> listRestaurantEntity = iRestaurantRepository.findAll();
		return listRestaurantEntity.stream()
				.map(currentRestaurant -> modelMapper.map(currentRestaurant, RestaurantJson.class))
				.collect(Collectors.toList());
	}

	private Restaurant getRestaurantEntity(Long id) throws BookingExceptions {
		return iRestaurantRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("SNOT-401-1", "RESTAURANT NOT FOUND"));
	}

}
