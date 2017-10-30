package com.test.auto.general.task_api.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * Created by Kushal Ahmed on 10/29/17.
 *
 * Value Object for storing bracket string, along with whether it is balanced or not.
 */
public class BracketVO {

    /**
     * Not Null and size constraints with messages added as annotations.
     */
    @NotNull(message = "Input field must be defined")
    private String input;

    private boolean isBalanced;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    /**
     * JsonProperty mentioned explicitly. It ensures the Boolean field name equals to the variable name.
     * Otherwise, 'balanced' field name is picked up instead of 'isBalanced'.
     */
    @JsonProperty(value="isBalanced")
    public boolean isBalanced() {
        return isBalanced;
    }

    public void setBalanced(boolean balanced) {
        isBalanced = balanced;
    }
}
