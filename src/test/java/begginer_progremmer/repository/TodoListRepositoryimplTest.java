package begginer_progremmer.repository;

import Entity.TodoList;
import Repository.TodoListRepository;
import Repository.TodoListRepositoryiImpl;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.DatabaseUtil;

public class TodoListRepositoryimplTest {
    private HikariDataSource dataSource;
    private TodoListRepository todoListRepository;



    @BeforeEach
    void setUp() {
        dataSource= DatabaseUtil.getDataSource();
        todoListRepository=new TodoListRepositoryiImpl(dataSource);

    }

    @Test
    void testAdd() {
        TodoList todoList=new TodoList();
        todoList.setTodo("dika");

        todoListRepository.add(todoList);
    }

    @Test
    void testRemove() {
        System.out.println(todoListRepository.remove(1));
        System.out.println(todoListRepository.remove(2));
        System.out.println(todoListRepository.remove(3));
        System.out.println(todoListRepository.remove(4));
    }

    @Test
    void testGetAll() {
      /* TodoList todoList=new TodoList();
       todoList.setTodo("dika");
       todoList.setTodo("dina");
       todoListRepository.add(todoList);*/

        TodoList[] todoList=todoListRepository.getAll();
        for(var todo : todoList){
            System.out.println(todo.getId()+" : " +todo.getTodo());
        }

    }

    @AfterEach
    void tearDown() {
        dataSource.close();
    }
}
