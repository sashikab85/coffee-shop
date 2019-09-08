package com.digital.coffeeshop.exception;

import org.springframework.http.HttpStatus;

/**
 * CustomException, handle Customer define exception.
 *
 * @author Sashika Bandara
 */
public class CustomException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String message;
    private HttpStatus httpStatus;
    private boolean error;

    public CustomException(String message, HttpStatus httpStatus, boolean error) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
        this.error = error;

    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
