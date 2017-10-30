package com.test.auto.general.task_api.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by Kushal Ahmed on 10/29/17.
 *
 * Value Object for ToDoItem as a representation from REST API.
 */
public class ToDoItemVO {

    private Long id;
    private String text;
    private Date createdAt;
    private Boolean isCompleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * JsonProperty mentioned explicitly. It ensures the Boolean field name equals to the variable name.
     * Otherwise, 'completed' field name is picked up instead of 'isCompleted'.
     */
    @JsonProperty(value="isCompleted")
    public Boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }
}
