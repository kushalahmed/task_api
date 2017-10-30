package com.test.auto.general.task_api.service;

import com.test.auto.general.task_api.entity.ToDoItem;
import com.test.auto.general.task_api.repository.IToDoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Kushal Ahmed on 10/29/17.
 *
 * Service class for ToDoItem, which operates through ToDoItemRepository
 */
@Service
public class ToDoItemService implements IToDoItemService {

    @Autowired
    private IToDoItemRepository todoItemRepository;

    @Override
    public ToDoItem getToDoItemById(Long id) {
        return todoItemRepository.findOne(id);
    }

    @Override
    public ToDoItem createToDoItem(ToDoItem todoItem) {
        return todoItemRepository.save(todoItem);
    }

    @Override
    public ToDoItem updateToDoItem(ToDoItem todoItem) {
        return todoItemRepository.save(todoItem);
    }

    @Override
    public void deleteToDoItem(Long id) {
        ToDoItem todoItem = getToDoItemById(id);
        if (todoItem != null) {
            todoItemRepository.delete(id);
        }
    }
}
