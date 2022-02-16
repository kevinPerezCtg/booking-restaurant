package com.boot.restaurantapi.exceptions;

import java.util.ArrayList;
import java.util.List;

import com.boot.restaurantapi.dtos.ErrorDto;

public class BookingExceptions extends Exception {
	
	static final long serialVersionUID = 1L;
	private final String code;
	private final int responseCode;
	private final List<ErrorDto> errorList = new ArrayList<>();
	
	public BookingExceptions(String code, int responseCode, String message) {
		super(message);
		this.code = code;
		this.responseCode = responseCode;
	}
	
	public BookingExceptions(String code, int responseCode, String message, List<ErrorDto> errorList) {
		super(message);
		this.code = code;
		this.responseCode = responseCode;
		this.errorList.addAll(errorList);
	}

	public String getCode() {
		return code;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public List<ErrorDto> getErrorList() {
		return errorList;
	}

}
