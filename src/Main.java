import TaskData.*;
public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();

        storage.createEpic("Епик 1","Описание Епик 1","NEW",1);


        System.out.println(storage.getEpicsMap());

        storage.createSubtask("Подзадача 1","Описание подзадачи 1","NEW",1,1);
        storage.createSubtask("Подзадача 2","Описание подзадачи 2","NEW",2,1);
        storage.createSubtask("Подзадача 3","Описание подзадачи 3","NEW",3,1);

        System.out.println((storage.getEpicsMap()));



    }
}
