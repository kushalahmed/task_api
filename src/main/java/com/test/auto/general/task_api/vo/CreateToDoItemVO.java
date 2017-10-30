package com.test.auto.general.task_api.vo;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Kushal Ahmed on 10/29/17.
 *
 * Value Object for ToDoItem while creating a new repository.
 */
public class CreateToDoItemVO {

    /**
     * Not Null and size constraints with messages added as annotations.
     */
    @NotNull(message = "Text field must be defined")
    @Size(min = 1, max = 50, message = "Must be between {min} and {max} chars long")
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
