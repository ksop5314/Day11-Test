package est.day11.todo.controller;

import est.day11.todo.dto.TodoResponse;
import est.day11.todo.service.TodoService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TodoViewController {

    private final TodoService todoService;

    public TodoViewController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/add_todo")
    public String addTodo(){
        return "add_todo";
    }

    @GetMapping("/todos")
    public String todoList(Model model) {
        List<TodoResponse> todoList = todoService.getTodoList();
        model.addAttribute("todoList", todoList);
        return "todos";
    }

    @GetMapping("/todos/{id}")
    public String todoDetails(@PathVariable Long id, Model model) {
        TodoResponse todoResponse = todoService.getTodo(id);
        model.addAttribute("todoResponse", todoResponse);
        return "todo";
    }

}
