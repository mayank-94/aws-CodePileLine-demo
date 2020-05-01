package com.spring.boot.todo.mytodoapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.todo.mytodoapp.bean.Todo;

@Repository
public interface TodoRepo extends JpaRepository<Todo, Integer>{
	
	List<Todo> findByUsername(String username);

}
