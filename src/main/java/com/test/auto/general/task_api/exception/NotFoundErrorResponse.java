package com.test.auto.general.task_api.exception;

/**
 * Created by Kushal Ahmed on 10/29/17.
 *
 * A second layer exception DTO class to encapsulate NotFoundError messages on field level.
 */
public class NotFoundErrorResponse extends ExceptionSubResponse {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
