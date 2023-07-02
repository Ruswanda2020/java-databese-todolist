package View;

import service.TodoListService;
import util.InputUtil;

public class TodoListView {

    private TodoListService todoListService;

    public TodoListView(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    public void showTodoListview(){
        while (true){

            todoListService.showTodoList();

            System.out.println("menu");
            System.out.println("1.tambah ");
            System.out.println("2.hapus");
            System.out.println("x.kelur");
            var input= InputUtil.input("pilih");

            if (input.equals("1")){
                addTodoListView();
            }else if(input.equals("2")){
                removeTodoListView();
            } else if (input.equals("x")) {
                break;
            }else {
                System.out.println("pilihan tidak di mengerti");
            }
        }
    }
    public void addTodoListView(){
        System.out.println("menambahkan TodoList ");
        var todo=InputUtil.input("todo(x jika batal )");
        if (todo.equals("x")){
            System.out.println("gagal menambahkan todo ");
        }else {
            todoListService.addTodoList(todo);
        }
    }
    public void removeTodoListView(){
        System.out.println("menghapus todolist ");
        var number=InputUtil.input("masukan todo yang ingin di hapus(tekan x jika ingin batal");
        if (number.equals("x")){
            System.out.println("batal");
        }else {
            todoListService.removeTodoList(Integer.valueOf(number));
        }
    }
}
