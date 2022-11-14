package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class GlobalExceptionHandler {

	@ExceptionHandler(PackageException.class)
	public ResponseEntity<MyErrorDetails> handleStudentException(PackageException exp,WebRequest req){

		MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(), exp.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);

	} 

	@ExceptionHandler(PaymentsDetailsException.class)
	public ResponseEntity<MyErrorDetails> handleStudentException(PaymentsDetailsException exp,WebRequest req){

		MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(), exp.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);

	} 

	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyErrorDetails> handleStudentException(UserException exp,WebRequest req){

		MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(), exp.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(VehicleException.class)
	public ResponseEntity<MyErrorDetails> handleStudentException(VehicleException exp,WebRequest req){

		MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(), exp.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);

	} 

	@ExceptionHandler(AdminException.class)
	public ResponseEntity<MyErrorDetails> handleStudentException(AdminException exp,WebRequest req){

		MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(), exp.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);

	} 
	
	@ExceptionHandler(ReportException.class)
	public ResponseEntity<MyErrorDetails> handleStudentException(ReportException exp,WebRequest req){

		MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(), exp.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	
	} 
	
	@ExceptionHandler(TravelsException.class)
	public ResponseEntity<MyErrorDetails> handleStudentException(TravelsException exp,WebRequest req){

		MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(), exp.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);

	} 

	@ExceptionHandler(RouteException.class)
	public ResponseEntity<MyErrorDetails> handleStudentException(RouteException exp,WebRequest req){

		MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(), exp.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);

	} 

	@ExceptionHandler(BookingException.class)
	public ResponseEntity<MyErrorDetails> handleStudentException(BookingException exp,WebRequest req){

		MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(), exp.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	
	} 

	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<MyErrorDetails> handleStudentException(CustomerException exp,WebRequest req){

		MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(), exp.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);

	}
	

	@ExceptionHandler(FeedbackException.class)
	public ResponseEntity<MyErrorDetails> handleStudentException(FeedbackException exp,WebRequest req){

		MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(), exp.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(HotelException.class)
	public ResponseEntity<MyErrorDetails> handleStudentException(HotelException exp,WebRequest req){

		MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(), exp.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);

	}
	

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> myMANVExceptionHandler(MethodArgumentNotValidException me) {

		MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(),"Validation Error",me.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);

	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> ExceptionHandler(Exception se, WebRequest req) {
		
		MyErrorDetails err= new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(se.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
		
	}

}
