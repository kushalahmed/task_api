package com.test.auto.general.task_api.repository;

import com.test.auto.general.task_api.entity.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Kushal Ahmed on 10/29/17.
 *
 * It uses JpaRepository which supports CRUD operations without a line of code!
 */
@Repository
public interface IToDoItemRepository extends JpaRepository<ToDoItem, Long> {
}
