package com.jferreira95.microservice.commonlib.exception.type;

import com.jferreira95.microservice.commonlib.exception.ExceptionCode;
import org.springframework.http.HttpStatus;

public class ForbiddenException extends CustomizedRuntimeException {

    /**
     * Instantiates a new Entity not found exception.
     *
     * @param exceptionCode the exception code
     */
    public ForbiddenException(ExceptionCode exceptionCode) {
        super(HttpStatus.FORBIDDEN, exceptionCode);
    }

    /**
     * Instantiates a new Internal server error exception.
     *
     * @param exceptionCode the exception code
     * @param parameters    the parameters
     */
    public ForbiddenException(ExceptionCode exceptionCode, Object... parameters) {
        super(HttpStatus.FORBIDDEN, exceptionCode, parameters);
    }
}
