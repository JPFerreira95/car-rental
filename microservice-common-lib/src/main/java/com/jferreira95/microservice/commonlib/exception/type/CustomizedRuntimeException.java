package com.jferreira95.microservice.commonlib.exception.type;

import com.jferreira95.microservice.commonlib.exception.ExceptionCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The type Customized runtime exception.
 */
@Getter
public abstract class CustomizedRuntimeException extends RuntimeException {

    private ExceptionResponse exceptionResponse;
    private HttpStatus httpStatus;

    /**
     * Instantiates a new Customized runtime exception.
     *
     * @param httpStatus the http status
     */
    protected CustomizedRuntimeException(HttpStatus httpStatus){
        this.httpStatus = httpStatus;
    }

    /**
     * Instantiates a new Customized runtime exception.
     *
     * @param httpStatus    the http status
     * @param exceptionCode the exception code
     * @param parameters    the parameters
     */
    protected CustomizedRuntimeException(HttpStatus httpStatus, ExceptionCode exceptionCode, Object... parameters) {
        this.httpStatus = httpStatus;
        Map<String, String> parametersMap = this.buildParameters(null, parameters);
        this.exceptionResponse = new ExceptionResponse(null, exceptionCode.getMessage(), parametersMap, null);
    }

    /**
     * Instantiates a new Customized runtime exception.
     *
     * @param httpStatus    the http status
     * @param exceptionCode the exception code
     * @param parameters    the parameters
     */
    protected CustomizedRuntimeException(HttpStatus httpStatus, ExceptionCode exceptionCode, Map<String, String> parameters) {
        this.httpStatus = httpStatus;
        this.exceptionResponse = new ExceptionResponse(null, exceptionCode.getMessage(), parameters, null);
    }

    /**
     * Instantiates a new Exception response.
     *
     * @param httpStatus    the http status
     * @param exceptionCode the exception code
     */
    protected CustomizedRuntimeException(HttpStatus httpStatus, ExceptionCode exceptionCode) {
        this.httpStatus = httpStatus;
        this.exceptionResponse = new ExceptionResponse(null, exceptionCode.getMessage(), null, null);
    }

    /**
     * Sets exception response.
     *
     * @param exceptionResponse the exception response
     */
    protected void setExceptionResponse(ExceptionResponse exceptionResponse) {
        this.exceptionResponse = exceptionResponse;
    }


    protected Map<String, String> buildParameters(String prefix, Object... parameters) {
        Map<String, String> parametersMap = new LinkedHashMap<>(parameters.length);

        AtomicInteger i = new AtomicInteger(1);
        Arrays.stream(parameters).forEach(e -> {
            String key = ObjectUtils.isEmpty(prefix) ? String.valueOf(i) : prefix + i;
            parametersMap.put(key, e.toString());
            i.getAndIncrement();
        });

        return parametersMap;
    }

}
