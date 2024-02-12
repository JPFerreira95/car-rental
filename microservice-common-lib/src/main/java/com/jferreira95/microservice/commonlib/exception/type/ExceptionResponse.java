package com.jferreira95.microservice.commonlib.exception.type;

import com.jferreira95.microservice.commonlib.exception.ExceptionCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The type Exception response.
 */
@Setter
@Getter
@AllArgsConstructor
public class ExceptionResponse {

    private Timestamp timestamp;
    private String message;
    private Map<String, String> parameters;
    private String details;

    /**
     * Instantiates a new Exception response.
     *
     * @param message    the message
     * @param parameters the parameters
     */
    public ExceptionResponse(String message, Map<String, String> parameters) {
        this.message = message;
        this.parameters = parameters;
    }

    /**
     * Instantiates a new exception response.
     *
     * @param timestamp         the timestamp
     * @param exceptionResponse the exception response
     */
    public ExceptionResponse(Timestamp timestamp, ExceptionResponse exceptionResponse) {
        this.timestamp = timestamp;
        this.message = exceptionResponse.getMessage();
        this.parameters = exceptionResponse.getParameters();
        this.details = exceptionResponse.getDetails();
    }

    /**
     * Instantiates a new Exception response.
     *
     * @param timestamp         the timestamp
     * @param exceptionResponse the exception response
     * @param details           the details
     */
    public ExceptionResponse(Timestamp timestamp, ExceptionResponse exceptionResponse, String details) {
        this.timestamp = timestamp;
        this.message = exceptionResponse.getMessage();
        this.parameters = exceptionResponse.getParameters();
        this.details = details;
    }

}
