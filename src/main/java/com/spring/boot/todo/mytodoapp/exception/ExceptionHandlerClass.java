package com.spring.boot.todo.mytodoapp.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ExceptionHandlerClass extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest req){
		return new ResponseEntity<Object>(
				new ErrorResponse("Internal Server Error", ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date()),
				HttpStatus.INTERNAL_SERVER_ERROR
				);
	}
	
	@ExceptionHandler(TodoNotFoundException.class)
	public final ResponseEntity<Object> todoNotFound(Exception ex, WebRequest req){
		return new ResponseEntity<Object>(
				new ErrorResponse("Not Found", ex.getMessage(), HttpStatus.NOT_FOUND.value(), new Date()),
				HttpStatus.NOT_FOUND
				);
	}
	
}
