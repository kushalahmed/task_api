package com.test.auto.general.task_api.exception;

import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Kushal Ahmed on 10/29/17.
 *
 * ControllerAdvice implementation for handling exceptions.
 */
@ControllerAdvice
public class ExceptionController {

    /**
     * Arranges the error message for ResourceNotFoundException
     *
     * @param   ex  ResourceNotFoundException instance thrown from the RestController.
     * @return  ExceptionResponse instance.
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> resourceNotFound(ResourceNotFoundException ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setName("NotFoundError");
        NotFoundErrorResponse exceptionSubResponse = new NotFoundErrorResponse();
        exceptionSubResponse.setMessage(ex.getPropertyName());
        response.setDetails(Arrays.asList(exceptionSubResponse));

        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
    }

    /**
     * Arranges the error message for MethodArgumentNotValidException
     *
     * @param   ex  MethodArgumentNotValidException instance thrown from the RestController.
     * @return  ExceptionResponse instance.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> methodArgumentNotValid(MethodArgumentNotValidException ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setName("ValidationError");
        List<ExceptionSubResponse> exceptionSubResponseList = getExceptoinSubResponse(
                ex.getBindingResult().getAllErrors()
        );
        response.setDetails(exceptionSubResponseList);
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * Arranges the error message for BindException
     *
     * @param   ex  BindException instance thrown from the RestController.
     * @return  ExceptionResponse instance.
     */
    @ExceptionHandler(BindException.class)
    public ResponseEntity<ExceptionResponse> parameterBindError(BindException ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setName("ValidationError");
        List<ExceptionSubResponse> exceptionSubResponseList = getExceptoinSubResponse(ex.getAllErrors());
        response.setDetails(exceptionSubResponseList);
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * Arranges the field level error messages in a List.
     *
     * @param   objectErrors    List of ObjectErrors
     * @return  List of ExceptionSubResponse instances.
     */
    private List<ExceptionSubResponse> getExceptoinSubResponse(List<ObjectError> objectErrors) {
        List<ExceptionSubResponse> exceptionSubResponseList = new ArrayList<ExceptionSubResponse>();
        for (ObjectError error : objectErrors) {
            FieldError fieldError = (FieldError) error;
            ValidationErrorResponse exceptionSubResponse = new ValidationErrorResponse();
            exceptionSubResponse.setLocation("params");
            exceptionSubResponse.setMsg(fieldError.getDefaultMessage());
            exceptionSubResponse.setParam(fieldError.getField());
            exceptionSubResponse.setValue(null);
            if (fieldError.getRejectedValue() != null)
                exceptionSubResponse.setValue(fieldError.getRejectedValue().toString());
            exceptionSubResponseList.add(exceptionSubResponse);
        }
        return exceptionSubResponseList;
    }
}
