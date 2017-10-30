package com.test.auto.general.task_api.assembler;

import com.test.auto.general.task_api.entity.ToDoItem;
import com.test.auto.general.task_api.vo.CreateToDoItemVO;
import com.test.auto.general.task_api.vo.ToDoItemVO;
import com.test.auto.general.task_api.vo.UpdateToDoItemVO;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Kushal Ahmed on 10/29/17.
 *
 * It assembles Value Objects and entities from one format to another while performing CRUD operations on repository.
 */
@Component
public class ToDoItemAssembler {

    /**
     * Converts a given CreateToDoItemVO value object into a ToDoItem entity.
     *
     * @param   createToDoItemVO    an instance of CreateToDoItemVO
     * @return  a ToDoItem instance
     */
    public ToDoItem toToDoItem(CreateToDoItemVO createToDoItemVO) {
        ToDoItem toDoItem = new ToDoItem();
        toDoItem.setText(createToDoItemVO.getText());
        toDoItem.setCompleted(false);
        toDoItem.setCreatedAt(new Date());
        return toDoItem;
    }

    /**
     * Updates an existing ToDoItem repository by the fields of given UpdateToDoItemVO value object.
     *
     * @param   updateToDoItemVO    an instance of UpdateToDoItemVO
     * @param   existingToDoItem    an instance of ToDoItem entity
     * @return  a ToDoItem instance
     */
    public void toToDoItem(UpdateToDoItemVO updateToDoItemVO, ToDoItem existingToDoItem) {
        if (updateToDoItemVO.getText() != null) {
            existingToDoItem.setText(updateToDoItemVO.getText());
        }
        if (updateToDoItemVO.getCompleted() != null) {
            Boolean isCompleted = Boolean.valueOf(updateToDoItemVO.getCompleted());
            existingToDoItem.setCompleted(isCompleted);
        }
    }

    /**
     * Converts a given ToDoItem entity into a ToDoItemVO value object.
     *
     * @param   todoItem    an instance of ToDoItem entity
     * @return  an instance of ToDoItemVO value object
     */
    public ToDoItemVO toToDoItemVO(ToDoItem todoItem) {
        ToDoItemVO todoItemVO = new ToDoItemVO();
        todoItemVO.setId(todoItem.getId());
        todoItemVO.setText(todoItem.getText());
        todoItemVO.setCompleted(todoItem.getCompleted());
        todoItemVO.setCreatedAt(todoItem.getCreatedAt());
        return todoItemVO;
    }
}
