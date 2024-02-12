package com.jferreira95.microservice.commonlib.exception;

/**
 * The enum Common exception code.
 */
public enum CommonExceptionCode implements ExceptionCode {

    /**
     * The Invalid argument.
     */
    INVALID_ARGUMENT("Invalid Argument."),
    /**
     * The Internal server error.
     */
    INTERNAL_SERVER_ERROR("Internal Server Error.");

    private final String message;

    CommonExceptionCode(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
