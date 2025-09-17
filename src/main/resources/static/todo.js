const deleteBtn = document.getElementById("delete-btn");

if (deleteBtn) {
  deleteBtn.addEventListener("click", e => {
    let id = document.getElementById("todo-id").value;
    fetch(`/api/todos/${id}`, {
      method: "DELETE"
    }).then(() => {
      alert("할 일이 삭제되었습니다.");
      location.replace("/todos");
    });
  });
}

const updateBtn = document.getElementById("update-btn");

if (updateBtn) {
  updateBtn.addEventListener("click", e => {
    let id = document.getElementById("todo-id").value;
    fetch(`/api/todos/${id}`, {
      method: "PUT"
    }).then(() => {
      alert("할 일의 상태가 변경되었습니다.");
      location.replace(`/todos/${id}`);
    });
  });
}

const addTodoBtn = document.getElementById("add-todo-btn");

if (addTodoBtn) {
  addTodoBtn.addEventListener("click", e => {
    fetch(`/api/todos`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({
        title: document.getElementById("title").value,
        completed: false
      })
    }).then(() => {
      alert("할 일이 등록되었습니다.");
      location.replace("/todos");
    });
  });
}