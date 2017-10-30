package com.test.auto.general.task_api.service;

import com.test.auto.general.task_api.entity.ToDoItem;
import com.test.auto.general.task_api.repository.IToDoItemRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
public class ToDoItemServiceTest {

    @TestConfiguration
    static class ToDoItemServiceTestContextConfiguration {

        @Bean
        public IToDoItemService todoItemService() {
            return new ToDoItemService();
        }
    }

    @Autowired
    private IToDoItemService todoItemService;

    @MockBean
    private IToDoItemRepository todoItemRepository;

    @Before
    public void setUp() {
        ToDoItem todoItem = new ToDoItem();
        long id = 1;
        todoItem.setId(id);

        Mockito.when(todoItemRepository.findOne(todoItem.getId()))
                .thenReturn(todoItem);

        Mockito.when(todoItemRepository.save(todoItem))
                .thenReturn(todoItem);
    }

    @Test
    public void whenValidId_thenToDoItemShouldBeFound() {
        long id = 1;
        ToDoItem found = todoItemService.getToDoItemById(id);

        assert(found.getId())
                .equals(id);
    }
}
