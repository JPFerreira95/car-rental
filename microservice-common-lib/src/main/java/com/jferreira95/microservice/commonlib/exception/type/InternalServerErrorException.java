package com.jferreira95.microservice.commonlib.exception.type;

import com.jferreira95.microservice.commonlib.exception.ExceptionCode;
import com.jferreira95.microservice.commonlib.exception.type.CustomizedRuntimeException;
import org.springframework.http.HttpStatus;

/**
 * The type Internal server error exception.
 */
public class InternalServerErrorException extends CustomizedRuntimeException {

    /**
     * Instantiates a new Entity not found exception.
     *
     * @param exceptionCode the exception code
     */
    public InternalServerErrorException(ExceptionCode exceptionCode) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, exceptionCode);
    }

    /**
     * Instantiates a new Internal server error exception.
     *
     * @param exceptionCode the exception code
     * @param parameters    the parameters
     */
    public InternalServerErrorException(ExceptionCode exceptionCode, Object... parameters) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, exceptionCode, parameters);
    }

}
