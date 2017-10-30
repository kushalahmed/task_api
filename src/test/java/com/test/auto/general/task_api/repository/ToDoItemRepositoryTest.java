package com.test.auto.general.task_api.repository;

import com.test.auto.general.task_api.entity.ToDoItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ToDoItemRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private IToDoItemRepository todoItemRepository;

    @Test
    public void whenFindById_thenReturnToDoItem() {
        // given
        ToDoItem todoItem = new ToDoItem();
        todoItem.setText("Integrate Swagger UI");
        entityManager.persist(todoItem);
        entityManager.flush();

        // when
        ToDoItem found = todoItemRepository.findOne(todoItem.getId());

        // then
        assertThat(found.getText(), is(todoItem.getText()));
    }

    @Test
    public void whenSaveAndUpdateByToDoItem_thenReturnUpdatedToDoItem() {
        // given
        ToDoItem todoItem = new ToDoItem();
        todoItem.setText("Integrate Swagger UI");

        // when
        todoItemRepository.save(todoItem);
        todoItem.setText("Integrate Swagger UI 2");
        ToDoItem found = todoItemRepository.save(todoItem);

        // then
        assertThat(found.getId(), is(todoItem.getId()));
        assertThat(found.getText(), is(todoItem.getText()));
    }
}
