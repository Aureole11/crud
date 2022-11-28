package com.crud.crud.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.async.AsyncWebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.crud.crud.model.Student;

@Async
@ControllerAdvice
public class StudentControllerAdvice extends ResponseEntityExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(StudentControllerAdvice.class);
	
   @SuppressWarnings("unused")
private ResponseEntity<Object> handleMethodArgumentNotValid(
		  MethodArgumentNotValidException methodArgumentNotValidException, HttpHeaders headers, HttpStatus status, AsyncWebRequest request){
	   String ERROR_MESSAGE = methodArgumentNotValidException.getMessage();
	   try {
		   ERROR_MESSAGE = methodArgumentNotValidException.getBindingResult().getFieldError().getDefaultMessage().strip();
	   }
	   catch(Exception e){
		   logger.error("Error constructing error message", e);
		    }
	   logger.error(ERROR_MESSAGE, methodArgumentNotValidException);
	   Student errorResponse = getErrorResponse(HttpStatus.BAD_REQUEST, ERROR_MESSAGE);
	    return handleExceptionInternal(methodArgumentNotValidException, errorResponse, headers, status, request );
   }
   
   @ExceptionHandler(StudentNotFoundException.class)

private Student getErrorResponse(HttpStatus badRequest, String ERROR_MESSAGE) {
	// TODO Auto-generated method stub
	return null;
}

}
