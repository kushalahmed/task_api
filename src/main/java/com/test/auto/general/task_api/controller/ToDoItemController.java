package com.test.auto.general.task_api.controller;


import com.test.auto.general.task_api.assembler.ToDoItemAssembler;
import com.test.auto.general.task_api.entity.ToDoItem;
import com.test.auto.general.task_api.service.IToDoItemService;
import com.test.auto.general.task_api.vo.CreateToDoItemVO;
import com.test.auto.general.task_api.vo.ToDoItemVO;
import com.test.auto.general.task_api.vo.UpdateToDoItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * Created by Kushal Ahmed on 10/29/17.
 *
 * Rest controller for API calls starting with /todo. It uses ToDoItemService and ToDoItemAssembler
 * for underlying business logic.
 */
@RestController
@RequestMapping("todo")
public class ToDoItemController {

    @Autowired
    private ToDoItemAssembler todoItemAssembler;

    @Autowired
    private IToDoItemService todoItemService;

    /**
     * Serves GET /todo/{id}.
     *
     * It retrieves a ToDoItem with the given id.
     *
     * ResourceNotFoundException is thrown if not found.
     *
     * @param   id  identifier of a ToDoItem entity
     * @return  an instance of ToDoItemVo value object
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ToDoItemVO getToDoItem(@PathVariable("id") Long id) {
        ToDoItem todoItem = todoItemService.getToDoItemById(id);
        if (todoItem != null) {
            return todoItemAssembler.toToDoItemVO(todoItem);
        }
        else {
            throw new ResourceNotFoundException("Item with " + id + " not found", null);
        }
    }

    /**
     * Serves POST /todo.
     *
     * It creates a ToDoItem entity.
     *
     * ResourceNotFoundException is thrown if not found.
     *
     * @param   createToDoItemVO  a CreateToDoItemVO value object capturing a ToDoItem details.
     * @return  an instance of ToDoItemVo value object.
     */
    @RequestMapping(method = RequestMethod.POST)
    public ToDoItemVO createToDoItem(@Validated @RequestBody CreateToDoItemVO createToDoItemVO) {
        //convert to ToDoItem
        ToDoItem todoItem = todoItemAssembler.toToDoItem(createToDoItemVO);
        //save ToDoItem
        ToDoItem savedToDoItem = todoItemService.createToDoItem(todoItem);
        //convert to ToDoItemVO
        return todoItemAssembler.toToDoItemVO(savedToDoItem);
    }

    /**
     * Serves PATCH /todo/1.
     *
     * It updates an existing ToDoItem identified by the given id.
     *
     *  ResourceNotFoundException, MethodArgumentNotValidException and BindException are thrown if not validated.
     *
     * @param   updateToDoItemVO  a UpdateToDoItemVO value object capturing a ToDoItem details.
     * @return  an instance of ToDoItemVo value object.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public ToDoItemVO updateToDoItem(@PathVariable("id") Long id,
                                     @Validated @RequestBody UpdateToDoItemVO updateToDoItemVO) {
        ToDoItem todoItem = todoItemService.getToDoItemById(id);
        if (todoItem != null) {
            //convert to ToDoItem
            todoItemAssembler.toToDoItem(updateToDoItemVO, todoItem);
            //update ToDoItem
            ToDoItem updatedToDoItem = todoItemService.updateToDoItem(todoItem);
            //convert to ToDoItemVO
            return todoItemAssembler.toToDoItemVO(updatedToDoItem);
        }
        else {
            throw new ResourceNotFoundException("Item with " + id + " not found", null);
        }
    }

    /**
     * Serves DELETE /todo/1.
     *
     * It deletes a ToDoItem identified by the given id.
     *
     * @param   id  identifier of a ToDoItem entity
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteToDoItem(@PathVariable("id") Long id) {
        todoItemService.deleteToDoItem(id);
    }
}
