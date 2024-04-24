package com.ty.ToDoList.services;

import java.util.ArrayList;

import com.ty.ToDoList.entity.ToDo;

public class ToDoModelView {
	
	
	
	private ArrayList<ToDo> todoList = new ArrayList<ToDo>();
	
	public ToDoModelView() {}
	
	public ToDoModelView(Iterable<ToDo> items) {
		items.forEach(todoList:: add);
	}

	public ToDoModelView(ArrayList<ToDo> todoList) {
		this.todoList = todoList;
	}

	public ArrayList<ToDo> getTodoList() {
		return todoList;
	}

	public void setTodoList(ArrayList<ToDo> todoList) {
		this.todoList = todoList;
	}

}
