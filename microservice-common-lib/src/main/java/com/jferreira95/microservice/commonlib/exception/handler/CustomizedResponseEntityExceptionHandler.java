package com.jferreira95.microservice.commonlib.exception.handler;

import com.jferreira95.microservice.commonlib.exception.CommonExceptionCode;
import com.jferreira95.microservice.commonlib.exception.type.CustomizedRuntimeException;
import com.jferreira95.microservice.commonlib.exception.type.ExceptionResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.Timestamp;
import java.time.Instant;

/**
 * The Class CustomizedResponseEntityExceptionHandler.
 */
@ControllerAdvice // any exception will be handled by this controller
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Handle all exceptions.
     *
     * @param ex      the ex
     * @param request the request
     * @return the response entity
     */
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {

        ExceptionResponse exceptionResponse = new ExceptionResponse(Timestamp.from(Instant.now()),
                CommonExceptionCode.INTERNAL_SERVER_ERROR.getMessage(),
                null,
                ex.getMessage());

        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Handle user not found exception.
     *
     * @param ex      the ex
     * @param request the request
     * @return the response entity
     */
    @ExceptionHandler(CustomizedRuntimeException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(CustomizedRuntimeException ex, WebRequest request) {

        ExceptionResponse exceptionResponse = new ExceptionResponse(Timestamp.from(Instant.now()), ex.getExceptionResponse());

        // return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(exceptionResponse, ex.getHttpStatus());
    }

    /**
     * Handle method argument not valid.
     * This method will handle the invalid argument exception
     *
     * @param ex      the ex
     * @param headers the headers
     * @param status  the status
     * @param request the request
     * @return the response entity
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {

        ExceptionResponse exceptionResponse = new ExceptionResponse(Timestamp.from(Instant.now()),
                CommonExceptionCode.INVALID_ARGUMENT.getMessage(),
                null,
                request.getDescription(false));

        // return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

}

