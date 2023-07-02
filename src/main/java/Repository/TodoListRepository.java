package Repository;

import Entity.TodoList;

public interface TodoListRepository {

    TodoList[] getAll();

    void add(TodoList todoList);
    boolean remove(Integer integer);
}
