package com.test.auto.general.task_api.service;

import com.test.auto.general.task_api.entity.ToDoItem;

/**
 * Created by Kushal Ahmed on 10/29/17.
 *
 * Service interface for ToDoItem
 */
public interface IToDoItemService {

    /**
     * Returns a ToDoItem identified by the given 'id'.
     *
     * @param   id
     * @return  ToDoItem if an item with 'id' is found, null otherwise
     */
    ToDoItem getToDoItemById(Long id);

    /**
     * Creates a ToDoItem at the repository.
     *
     * @param   todoItem    bean for the ToDoItem object
     * @return  ToDoItem if an item was created, null otherwise
     */
    ToDoItem createToDoItem(ToDoItem todoItem);

    /**
     * Updates the given ToDoItem at the repository.
     *
     * @param   todoItem    bean for the ToDoItem object
     * @return  ToDoItem if an item exists, null otherwise
     */
    ToDoItem updateToDoItem(ToDoItem todoItem);

    /**
     * Deletes the ToDoItem identified by the given 'id'.
     *
     * @param   id  id of the ToDoItem
     */
    void deleteToDoItem(Long id);
}
