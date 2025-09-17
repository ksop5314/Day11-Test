package est.day11.todo.dto;

import est.day11.todo.entity.Todo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddTodoRequest {

    private String title;
    private boolean completed;

    public Todo toEntity() {
        return Todo.builder()
            .title(this.title)
            .completed(this.completed)
            .build();
    }

}
