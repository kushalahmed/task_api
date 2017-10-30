package com.test.auto.general.task_api.controller;

import com.test.auto.general.task_api.assembler.ToDoItemAssembler;
import com.test.auto.general.task_api.entity.ToDoItem;
import com.test.auto.general.task_api.service.IToDoItemService;
import com.test.auto.general.task_api.vo.ToDoItemVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(ToDoItemController.class)
public class ToDoItemControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ToDoItemAssembler todoItemAssembler;

    @MockBean
    private IToDoItemService todoItemService;

    @Test
    public void givenToDoItem_whenGetToDoItem_thenReturnToDoItem()
            throws Exception {

        ToDoItem todoItem = new ToDoItem();
        todoItem.setText("item 1");
        long id = 1;
        todoItem.setId(id);

        ToDoItemVO todoItemVO = new ToDoItemVO();
        todoItemVO.setId(todoItem.getId());
        todoItemVO.setText(todoItem.getText());

        // given
        given(todoItemService.getToDoItemById(id)).willReturn(todoItem);
        given(todoItemAssembler.toToDoItemVO(todoItem)).willReturn(todoItemVO);


        // when and then
        mvc.perform(get("/todo/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(todoItem.getId()))
                .andExpect(jsonPath("text").value(todoItem.getText()));
    }
}
