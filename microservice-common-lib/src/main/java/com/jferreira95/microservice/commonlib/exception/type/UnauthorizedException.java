package com.jferreira95.microservice.commonlib.exception.type;

import com.jferreira95.microservice.commonlib.exception.ExceptionCode;
import com.jferreira95.microservice.commonlib.exception.type.CustomizedRuntimeException;
import org.springframework.http.HttpStatus;

/**
 * The type Unauthorized exception.
 */
public class UnauthorizedException extends CustomizedRuntimeException {

    /**
     * Instantiates a new Unauthorized exception.
     *
     * @param exceptionCode the exception code
     */
    protected UnauthorizedException(ExceptionCode exceptionCode) {
        super(HttpStatus.UNAUTHORIZED, exceptionCode);
    }

    /**
     * Instantiates a new Unauthorized exception.
     *
     * @param exceptionCode the exception code
     * @param parameters    the parameters
     */
    protected UnauthorizedException(ExceptionCode exceptionCode, Object... parameters) {
        super(HttpStatus.UNAUTHORIZED, exceptionCode, parameters);
    }
}
