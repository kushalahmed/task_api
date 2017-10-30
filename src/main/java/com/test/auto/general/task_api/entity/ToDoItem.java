package com.test.auto.general.task_api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;


/**
 * Created by Kushal Ahmed on 10/29/17.
 *
 * Entity class for storing ToDoItem details
 */
@Entity
@Table(name = "todo_item")
public class ToDoItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "text")
    @Size(min = 1, max = 50)
    private String text;

    @Column(name = "created_at")
    @CreationTimestamp
    private Date createdAt;

    @Column(name="is_completed")
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
    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }
}
