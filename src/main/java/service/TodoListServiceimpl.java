package service;

import Entity.TodoList;
import Repository.TodoListRepository;

public class TodoListServiceimpl implements TodoListService{

    private TodoListRepository todoListRepository;

    public TodoListServiceimpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public void showTodoList() {
        TodoList[] model=todoListRepository.getAll();
        System.out.println("TODOLIST");
        for (var todo : model) {
            System.out.println(todo.getId()+" "+todo.getTodo());
        }
    }
    @Override
    public void addTodoList(String todo) {
        TodoList todoList=new TodoList(todo);
        todoListRepository.add(todoList);
        System.out.println("sukses menambahkan todo : "+todo);
    }

    @Override
    public void removeTodoList(Integer number) {
        Boolean succses=todoListRepository.remove(number);
        if (succses){
            System.out.println("sukses menghapus todo ke : "+number);
        }else {
            System.out.println("gagal menghapus todo ke : "+number);
        }

    }

}
