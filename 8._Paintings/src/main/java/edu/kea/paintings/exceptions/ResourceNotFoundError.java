package edu.kea.paintings.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundError extends RuntimeException {

    public ResourceNotFoundError(String message){
        super(message);
    }

}
