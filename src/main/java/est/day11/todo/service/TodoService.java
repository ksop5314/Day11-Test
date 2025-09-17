package est.day11.todo.service;

import est.day11.todo.dto.AddTodoRequest;
import est.day11.todo.dto.TodoResponse;
import est.day11.todo.entity.Todo;
import est.day11.todo.repository.TodoRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // 할 일 리스트
    public List<TodoResponse> getTodoList() {
        List<TodoResponse> todoResponseList = todoRepository.findAll()
            .stream()
            .map(todo -> new TodoResponse(todo))
            .toList();

        return todoResponseList;
    }

    // 할 일 추가
    public Todo addTodo(AddTodoRequest addTodoRequest) {
        return todoRepository.save(addTodoRequest.toEntity());
    }

    public TodoResponse getTodo(Long id) {
        Todo todoResponse = todoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("없는 Todo 입니다."));

        return new TodoResponse(todoResponse);
    }

    // 특정 할 일 상태 변경
    @Transactional
    public Todo updateCompleted(Long id) {
        Todo todo = todoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("없는 Todo 입니다."));


        System.out.println("★★★★★★★★★★★★★★★★★★★ 초기 상태 : " + todo.isCompleted());
        boolean reverseBoolean = !todo.isCompleted();
        System.out.println("★★★★★★★★★★★★★★★★★★★ 변경 값 확인 : " + reverseBoolean);

        todo.updateTodo(reverseBoolean);
        System.out.println("★★★★★★★★★★★★★★★★★★★ 변경 후 상태 : " + todo.isCompleted());

        return todo;
    }

    // 특정 할 일 삭제
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }


}
