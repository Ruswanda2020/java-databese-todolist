import Repository.TodoListRepository;
import Repository.TodoListRepositoryiImpl;
import View.TodoListView;
import com.zaxxer.hikari.HikariDataSource;
import service.TodoListService;
import service.TodoListServiceimpl;
import util.DatabaseUtil;

import javax.sql.DataSource;

public class ApplikasiTodoListV2 {
    public static void main(String[] args) {

        DataSource dataSource= DatabaseUtil.getDataSource();

        TodoListRepository todoListRepository=new TodoListRepositoryiImpl(dataSource);
        TodoListService todoListService=new TodoListServiceimpl(todoListRepository);
        TodoListView todoListView=new TodoListView(todoListService);
        todoListView.showTodoListview();
    }
}
