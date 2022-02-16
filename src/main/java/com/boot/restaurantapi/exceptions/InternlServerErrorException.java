package com.boot.restaurantapi.exceptions;

import java.util.Arrays;

import org.springframework.http.HttpStatus;

import com.boot.restaurantapi.dtos.ErrorDto;

public class InternlServerErrorException extends BookingExceptions {

	private static final long serialVersionUID = 1L;

	public InternlServerErrorException(String code, String message) {
		super(code, HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
	}
	
	public InternlServerErrorException(String code, String message, ErrorDto data) {
		super(code, HttpStatus.INTERNAL_SERVER_ERROR.value(), message, Arrays.asList(data));
	}
	
}
