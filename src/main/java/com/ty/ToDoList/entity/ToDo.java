package com.ty.ToDoList.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ToDo{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String category;
    private String name;
    private boolean complete;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isComplete() {
		return complete;
	}
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	
	public ToDo(String category, String name) {
		this.category = category;
		this.name = name;
		this.complete = false;
	}
	public ToDo() {

	}
	@Override
	public String toString() {
		return "ToDo [id=" + id + ", category=" + category + ", name=" + name + ", complete=" + complete + "]";
	}
	
	
    
    

}
