import TaskData.*;
public class Main {
    public static void main(String[] args) {

        TaskManager taskManager = Managers.getDefault();


        taskManager.createTask("Задача 1","Описание задачи 1",TaskStatus.NEW,1);
        taskManager.createTask("Задача 2","Описание задачи 2",TaskStatus.NEW,2);
        taskManager.createTask("Задача 3","Описание задачи 3",TaskStatus.NEW,3);
        taskManager.createTask("Задача 4","Описание задачи 1",TaskStatus.NEW,4);
        taskManager.createTask("Задача 5","Описание задачи 2",TaskStatus.NEW,5);
        taskManager.createTask("Задача 6","Описание задачи 3",TaskStatus.NEW,6);
        taskManager.createTask("Задача 7","Описание задачи 1",TaskStatus.NEW,7);
        taskManager.createTask("Задача 8","Описание задачи 2",TaskStatus.NEW,8);
        taskManager.createTask("Задача 9","Описание задачи 3",TaskStatus.NEW,9);

        taskManager.createEpic("Эпик 1","Описание эпик 1",TaskStatus.NEW,1);
        taskManager.createEpic("Эпик 2","Описание эпик 2",TaskStatus.NEW,2);

        taskManager.getTaskById(1);
        taskManager.getTaskById(2);
        taskManager.getTaskById(3);
        taskManager.getTaskById(4);
        taskManager.getTaskById(5);
        taskManager.getTaskById(6);
        taskManager.getTaskById(7);
        taskManager.getTaskById(8);
        taskManager.getTaskById(9);

        System.out.println( taskManager.getHistory());

        taskManager.getEpicById(2);
        taskManager.getEpicById(1);

        System.out.println( taskManager.getHistory());


    }
}
