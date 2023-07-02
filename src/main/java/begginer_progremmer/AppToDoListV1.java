package begginer_progremmer;

import java.util.Scanner;

public class AppToDoListV1 {
    public static String[] data=new String[10];
    static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("TODOLIST");
       viewShowTodoList();
    }
    /**
     * menampilkan todolist
     */
    public static void showTodoList(){
        for(var i=0;i<data.length;i++){
            var todo=data[i];
            var no=i+1;
            if (todo!=null){
                System.out.println(no+". "+todo);
            }
        }

    }
    public static void tesShowTodoList(){
        data[0]="belajar java dasar";
        data[1]="study kasus belajar java dasar:aplikasi todolist";
        data[2]="belajar logic aplikasi todolist";
        showTodoList();
    }
    /**
     * menambahkan todo ke list
     */
    public static void addTodoList(String todo){
       //cek apakah data penuh?
        var isfull=true;
        for (var i=0;i< data.length;i++){
            if (data[i]==null){
                //data masih ada yang kosong
                isfull=false;
            }
        }
        //jika array sudah penuh maka resize ukuranyah 2*lipat
        if (isfull){
           var temp=data;
            data=new String[data.length*2];
            for (var i=0;i<temp.length;i++){
                data[i]=temp[i];
            }
        }

        //tambahkan ke posisi yang data arraynyah null
        for (var i=0;i< data.length;i++){
            if (data[i]==null){
                data[i]=todo;
                break;
            }
        }
    }
    public static void testAddTodoList(){
        for (var i=0;i<25;i++){
            addTodoList("todo ke  : "+i);
        }
        showTodoList();
    }
    /**
     * menghapus todolist
     */
    public static Boolean removeTodoList(Integer number){
        if ((number-1) >= data.length){
            return false;
        } else if (data[number-1] == null) {
            return false;
        }else {
            for (var i=(number-1);i < data.length;i++){
                if (i==(data.length-1)){
                    data[i]=null;
                }else {
                    data[i]=data[i+1];
                }
            }
            return true;
        }
    }
    public static void tesRemoveTodoList(){

        addTodoList("SATU");
        addTodoList("DUA");
        addTodoList("TIGA");
        addTodoList("EMPAT");
        removeTodoList(1);

        showTodoList();
    }
    public static String input(String info){
        System.out.print(info+" : ");
        String data=scanner.nextLine();
        return data;
    }
    public static void tesInput(){
        var name=input("name");
        System.out.println("Hi"+" "+name);

        var chanel=input("chanel");
        System.out.println("hai  "+name+"selamat datang di chanel "+chanel);
    }
    /**
     * menampilkan view todolist
     */
    public static void viewShowTodoList(){

        while (true){

            showTodoList();
            System.out.println("menu");
            System.out.println("1.tambah ");
            System.out.println("2.hapus");
            System.out.println("x.kelur");
            var input=input("pilih");

            if (input.equals("1")){
                viewAddTodoList();
            }else if(input.equals("2")){
                viewRemoveTodoList();
            } else if (input.equals("x")) {
                break;
            }else {
                System.out.println("pilihan tidak di mengerti");
            }
        }
    }

    public static void tesViewTodoList(){
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");
        addTodoList("empat");
        addTodoList("lima");
        addTodoList("enam");

        viewShowTodoList();
    }
    /**
     * menampilkan view add todolist
     */
    public static void viewAddTodoList(){

        System.out.println("MENAMBAH TODOLIST");
        var todo=input("todo(x jika batal)");

        if (todo.equals("x")){
            //batal
        }else {
            addTodoList(todo);
        }
    }
    public static void tesViewAddTodoList(){

        addTodoList("bangun pagi");
        addTodoList("sarapan");
        addTodoList("berangkat kerja");

        viewAddTodoList();
        showTodoList();
    }
    /**
     * menamplikan view remove todolist
     */
    public static void viewRemoveTodoList(){
        System.out.println("MENGHAPUS TODOLIST");
        var number=input("nomor yang di hapus(x jika gagal");

        if (number.equals("x")){
            //batal
        }else {
         boolean sucsses=removeTodoList(Integer.valueOf(number));
         if (!sucsses){
             System.out.println("gagal menghapus todolist");
         }
        }
    }
    public static void tesViewRemoveTodoList(){


        showTodoList();
        viewRemoveTodoList();
        showTodoList();
    }


}
