package com.jferreira95.microservice.commonlib.exception.type;

import com.jferreira95.microservice.commonlib.exception.ExceptionCode;
import org.springframework.http.HttpStatus;

import java.util.Map;

/**
 * The type Entity not found exception.
 */
public class NotFoundException extends CustomizedRuntimeException {

    /**
     * Instantiates a new Entity not found exception.
     *
     * @param exceptionCode the exception code
     * @param ids           the ids
     */
    public NotFoundException(ExceptionCode exceptionCode, Object... ids) {
        super(HttpStatus.NOT_FOUND);

        // Treatment of ids
        Map<String, String> parameters = buildParameters("id_", ids);

        this.setExceptionResponse(new ExceptionResponse(exceptionCode.getMessage(), parameters));
    }

    /**
     * Instantiates a new Entity not found exception.
     *
     * @param exceptionCode the exception code
     */
    public NotFoundException(ExceptionCode exceptionCode) {
        super(HttpStatus.NOT_FOUND, exceptionCode);
    }
}
