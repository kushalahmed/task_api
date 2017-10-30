package com.test.auto.general.task_api.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Kushal Ahmed on 10/29/17.
 *
 * A second layer exception DTO class to encapsulate ValidationError messages on field level.
 */
public class ValidationErrorResponse extends ExceptionSubResponse {

    private String location;
    private String param;
    private String msg;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String value;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
