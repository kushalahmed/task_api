package com.test.auto.general.task_api.exception;

import java.util.List;

/**
 * Created by Kushal Ahmed on 10/29/17.
 *
 * The top level exception DTO class to encapsulate error messages. It consists of 'name' of the error,
 * and a list of 'details' explaining all the errors.
 */
public class ExceptionResponse {

    private String name;
    private List<ExceptionSubResponse> details;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ExceptionSubResponse> getDetails() {
        return details;
    }

    public void setDetails(List<ExceptionSubResponse> details) {
        this.details = details;
    }
}
