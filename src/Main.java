import TaskData.*;
public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();

        storage.createTask("Задача1","Описсание задачи 1","NEW",1);
        storage.createTask("Задача2","Описсание задачи 2","NEW",2);

        System.out.println(storage.getTasksMap());

        storage.deleteTaskById(1);

        System.out.println(storage.getTasksMap());


    }
}
