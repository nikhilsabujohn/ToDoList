package com.ty.ToDoList.dao;

import org.springframework.data.repository.CrudRepository;

import com.ty.ToDoList.entity.ToDo;

public interface ToDoRepository extends CrudRepository<ToDo, Integer> {

	    int countByCompleteTrue();

}
