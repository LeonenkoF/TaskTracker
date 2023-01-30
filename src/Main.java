import TaskData.*;
public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();

        storage.createTask("Задача 1","Пример простой задачи 1","NEW",1);
        storage.createTask("Задача 1","Пример простой задачи 1","NEW",1);

        storage.createEpic("Епик 1","Пример епика 1","NEW",1);
        storage.createEpic("Епик 2","Пример епика 2","NEW",2);

        storage.createSubtask("Подзадача 1","Пример подзадачи 1","NEW",1,1);
        storage.createSubtask("Подзадача 2","Пример подзадачи 2","NEW",2,1);

        storage.createSubtask("Подзадача 1","Пример подзадачи 1","NEW",1,2);

        System.out.println(storage.getTasksMap());
        System.out.println(storage.getEpicsMap());

        storage.updateSubtask("Подзадача 2","Пример подзадачи 2","DONE",2,1);
        storage.updateSubtask("Подзадача 2","Пример подзадачи 2","DONE",1,2);

        System.out.println(storage.getEpicsMap());
    }
}
