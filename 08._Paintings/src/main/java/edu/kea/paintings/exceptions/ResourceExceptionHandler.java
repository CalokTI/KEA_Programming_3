package edu.kea.paintings.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundError.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundError ex, WebRequest request){
        ErrorDetail errorDetail = new ErrorDetail(ZonedDateTime.now(ZoneId.of("Europe/Copenhagen")), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);
    }

}
