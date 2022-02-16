package com.boot.restaurantapi.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.boot.restaurantapi.exceptions.BookingExceptions;
import com.boot.restaurantapi.jsons.RestaurantJson;
import com.boot.restaurantapi.jsons.TurnJson;
import com.boot.restaurantapi.responses.BookingResponse;
import com.boot.restaurantapi.services.IRestaurantService;

public class RestaurantControllerTest {
	
	private static final Long RESTAURANT_ID = 1l;
	private static final String NAME = "Hamburguesa";
	private static final String DESCRIPTION = "Todo tipo de hamburguesa";
	private static final String ADDRESS = "Calle hamburguesa";
	private static final String IMAGE = "www.image.com";
	
	private static final String SUCCESS_STATUS = "Success";
	private static final String SUCCESS_CODE = "200 OK";
	private static final String MESSAGE = "OK";
	
	private static final RestaurantJson RESTAURANT_JSON = new RestaurantJson();
	private static final List<TurnJson> TURN_LIST = new ArrayList<>();
	
	@Mock
	IRestaurantService iRestaurantService;
	
	@InjectMocks
	RestaurantController restaurantController;
	
	@BeforeEach
	public void init() throws BookingExceptions{
		MockitoAnnotations.initMocks(this);
		
		RESTAURANT_JSON.setId(RESTAURANT_ID);
		RESTAURANT_JSON.setName(NAME);
		RESTAURANT_JSON.setDescription(DESCRIPTION);
		RESTAURANT_JSON.setAddress(ADDRESS);
		RESTAURANT_JSON.setImage(IMAGE);
		RESTAURANT_JSON.setTurns(TURN_LIST);		
		
		Mockito.when(iRestaurantService.getRestaurantById(RESTAURANT_ID)).thenReturn(RESTAURANT_JSON);
	}
	
	@Test
	public void getRestaurantById() throws BookingExceptions {
		final BookingResponse<RestaurantJson> response = restaurantController.getRestaurantById(RESTAURANT_ID);
		assertEquals(response.getStatus(), SUCCESS_STATUS);
		assertEquals(response.getCode(), SUCCESS_CODE);
		assertEquals(response.getMessage(), MESSAGE);
		assertEquals(response.getData(), RESTAURANT_JSON);
	}
	
	
	
	
	
}
