package com.ty.ToDoList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ty.ToDoList.dao.ToDoRepository;
import com.ty.ToDoList.entity.ToDo;

@Controller
@RequestMapping(path="/todo")
public class ToDoRestController {
	
	
	@Autowired
    private ToDoRepository repository;

    @GetMapping("/all")
    public @ResponseBody Iterable<ToDo> getAll() {
        Iterable<ToDo> todoList = repository.findAll();
        return repository.findAll();
    }

    @PostMapping("/add")
    public @ResponseBody Result addItem(@RequestParam String name, @RequestParam String category) {
    	ToDo item = new ToDo(category, name);
    	ToDo saved = repository.save(item);
        return new Result("Added", saved);
    }

    @PostMapping("/update")
    public @ResponseBody Result updateItem(@RequestParam int id, @RequestParam String name,
            @RequestParam String category, @RequestParam boolean isComplete) {
    	ToDo item = new ToDo(category, name);
        item.setId(id);
        item.setComplete(isComplete);
        ToDo saved = repository.save(item);
        return new Result("Updated", saved); 
     }
    
    class Result {
        private String status;
        private ToDo item;

        public Result() {
            status = "";
            item = null;
        }
        public Result(String status, ToDo item) {
            this.status = status;
            this.item = item;
        }

        public ToDo getItem() {
            return item;
        }

        public void setItem(ToDo item) {
            this.item = item;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

}
