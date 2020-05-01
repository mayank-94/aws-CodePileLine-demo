package com.spring.boot.todo.mytodoapp.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spring.boot.todo.mytodoapp.bean.Todo;
import com.spring.boot.todo.mytodoapp.exception.TodoNotFoundException;
import com.spring.boot.todo.mytodoapp.repo.TodoRepo;

@RestController
public class TodoController {
	
	@Autowired
	private TodoRepo repo;
	
	@GetMapping(path = "/all-todos")
	public List<Todo> retrieveAll(){
		return repo.findAll();
	}
	
	@GetMapping(path = "/all-todos/{username}/users")
	public List<Todo> retrieveByUser(@PathVariable String username){
		return repo.findByUsername(username);
	}
	
	@GetMapping(path = "/all-todos/{id}")
	public Todo retrieveById(@PathVariable int id) {
		Optional<Todo> todo = repo.findById(id);
		if(!todo.isPresent())
			throw new TodoNotFoundException("Todo not present with ID "+id);
		
		return todo.get();
	}
	
	@DeleteMapping(path = "/all-todos/{id}")
	public void deleteTodo(@PathVariable int id) {
		repo.deleteById(id);
	}
	
	@PostMapping(path = "/all-todos")
	public ResponseEntity<Object> createTodo(@RequestBody Todo todo){
		Todo saved = repo.save(todo);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(saved.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
}
