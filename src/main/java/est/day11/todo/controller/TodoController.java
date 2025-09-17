package est.day11.todo.controller;

import est.day11.todo.dto.AddTodoRequest;
import est.day11.todo.dto.TodoResponse;
import est.day11.todo.entity.Todo;
import est.day11.todo.service.TodoService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity<Todo> addTodo(@RequestBody AddTodoRequest addTodoRequest) {
        Todo todo = todoService.addTodo(addTodoRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(todo);
    }

    @GetMapping
    public ResponseEntity<List<TodoResponse>> getAllTodos() {
        List<TodoResponse> todoList = todoService.getTodoList();
        return ResponseEntity.status(HttpStatus.OK)
            .body(todoList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id) {
        Todo todo = todoService.updateCompleted(id);
        return ResponseEntity.status(HttpStatus.OK)
            .body(todo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.ok().build();
    }

}
