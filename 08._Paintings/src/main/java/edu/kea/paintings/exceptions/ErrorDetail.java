package edu.kea.paintings.exceptions;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class ErrorDetail {
    private ZonedDateTime timestamp;
    private String message;
    private String details;

    public ErrorDetail(ZonedDateTime timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

}
