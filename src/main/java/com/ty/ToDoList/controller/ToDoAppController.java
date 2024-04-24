package com.ty.ToDoList.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ty.ToDoList.dao.ToDoRepository;
import com.ty.ToDoList.entity.ToDo;
import com.ty.ToDoList.services.ToDoModelView;

	@Controller
	public class ToDoAppController {

		@Autowired
	    private ToDoRepository repository;

		@GetMapping("/")
		public String index(Model model) {
			Iterable<ToDo> todoList = repository.findAll();
			model.addAttribute("items", new ToDoModelView(todoList));
			model.addAttribute("newitem", new ToDo());
	    	return "index";
		}
		
		 @GetMapping("/tasks/completed")
		    public String getCompletedTasks(Model model) {
		        int completedTasks = repository.countByCompleteTrue();
		        model.addAttribute("completedTasks", completedTasks);
		        return "tasks";
		    }

		@PostMapping("/add")
		public String add(@ModelAttribute ToDo requestItem) {
			ToDo item = new ToDo(requestItem.getCategory(),requestItem.getName());
			repository.save(item);
		  	return "redirect:/";
		}

		@PostMapping("/update")
		public String update(@ModelAttribute ToDoModelView requestItems) {
			for (ToDo requestItem : requestItems.getTodoList() ) {
				ToDo item = new ToDo(requestItem.getCategory(), requestItem.getName());
				item.setComplete(requestItem.isComplete());
				item.setId(requestItem.getId());
				repository.save(item);
			}
			return "redirect:/";
		}

	  
}

