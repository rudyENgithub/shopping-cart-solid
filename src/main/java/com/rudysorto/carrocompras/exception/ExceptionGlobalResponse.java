package com.rudysorto.carrocompras.exception;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rudysorto.carrocompras.api.dto.Response;
import com.rudysorto.carrocompras.util.Time;


/*
Author: Rudy Sorto rudy.eli.ayala@gmail.com
Objective: Catcher class to handle all exceptions defined by us
*/
@ControllerAdvice
public class ExceptionGlobalResponse {

	Response result;
	
	  @ExceptionHandler(UnauthorizedException.class)
	    public ResponseEntity<Response> unauthorizedException(UnauthorizedException e) { 
			result = new Response(Time.getTime(), "[Exception Response] - Exception: " + e.getMessage(), 401, "UNAUTHORIZED");
			return new ResponseEntity<>(result, HttpStatus.UNAUTHORIZED);
	    }

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Response> runtimeException(RuntimeException e) {
		result = new Response(Time.getTime(), "[Exception Response] - Exception: " + e.getMessage(), 500, "Error");
		return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Response> exception(Exception e) {
		result = new Response(Time.getTime(), "[Exception Response] - Exception: " + e.getMessage(), 500, "Error");
		return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(DataAccessException.class)
	public ResponseEntity<Response> exception(DataAccessException e) {
		result = new Response(Time.getTime(), "[Exception Response] - Exception: " + e.getMessage(), 500, "Error");
		return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Response> exception(NotFoundException e) {
		result = new Response(Time.getTime(), "[Exception Response] - Exception: " + e.getMessage(), 404, "Error");
		return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AllReadyException.class)
	public ResponseEntity<Response> exception(AllReadyException e) {
		result = new Response(Time.getTime(), "[Exception Response] - Exception: " + e.getMessage(), 400, "Error");
		return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Response> exception(IllegalArgumentException e) {
		result = new Response(Time.getTime(), "[Exception Response] - Exception: " + e.getMessage(), 400, "Error");
		return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(FieldNotEmptyException.class)
	public ResponseEntity<Response> exception(FieldNotEmptyException e) {
		result = new Response(Time.getTime(), "[Exception Response] - Exception: " + e.getMessage(), 400, "Error");
		return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(FieldNotNullException.class)
	public ResponseEntity<Response> exception(FieldNotNullException e) {
		result = new Response(Time.getTime(), "[Exception Response] - Exception: " + e.getMessage(), 400, "Error");
		return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(FieldMustExistException.class)
	public ResponseEntity<Response> exception(FieldMustExistException e) {
		result = new Response(Time.getTime(), "[Exception Response] - Exception: " + e.getMessage(), 400, "Error");
		return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
	}
	 
	
	
	 
}