package com.example.todocrud.services;

import com.example.todocrud.entity.Todo;
import com.example.todocrud.entity.Users;
import com.example.todocrud.repository.ToDoRepository;
import com.example.todocrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;


@Service
public class TodoServices {

    @Autowired
    UserServices userServices;
    @Autowired
    ToDoRepository toDoRepository;
    @Autowired
    UserRepository userRepository;

    public Todo getTodoById(Long todoId){
        // write code
        return toDoRepository.findById(todoId).orElseThrow(() -> new NoSuchElementException());
    }

    public void addTodo(Long userId, Todo todo){
        // write code
        Users users = userServices.getUserById(userId);
        users.getTodoList().add(todo);
       userRepository.save(users);
    }

    public void deleteTodo(Long userId, Long todoId) {
        Users users = userServices.getUserById(userId);
        Todo todo = getTodoById(todoId);

        users.getTodoList().remove(todo);
        userRepository.save(users);
        toDoRepository.deleteById(todoId);
    }


    public void toggleTodoCompleted(Long todoId){
        Todo todo = this.getTodoById(todoId);
        todo.setCompleted(!todo.getCompleted());
        toDoRepository.save(todo);
    }

    public void updateTodo(Todo todo) {
        // write code
        toDoRepository.save(todo);
    }


}
