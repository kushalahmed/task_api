package com.test.auto.general.task_api.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Kushal Ahmed on 10/29/17.
 *
 * Value Object for ToDoItem while updating an existing repository.
 */
public class UpdateToDoItemVO {

    /**
     * Not Null and size constraints with messages added as annotations.
     */
    @Size(min = 1, max = 50, message = "Must be between {min} and {max} chars long")
    private String text;

    /**
     * Boolean value constraints with messages added as annotations.
     */
    @Pattern(regexp="true|false", message="isCompleted value should be a boolean")
    private String isCompleted;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    /**
     * JsonProperty mentioned explicitly. It ensures the Boolean field name equals to the variable name.
     * Otherwise, 'completed' field name is picked up instead of 'isCompleted'.
     */
    @JsonProperty(value="isCompleted")
    public String getCompleted() {
        return isCompleted;
    }

    public void setCompleted(String completed) {
        isCompleted = completed;
    }
}
