package TaskData;

import java.util.HashMap;

public class Storage {
    HashMap<Integer,Task> tasksMap = new HashMap<>();



    public void createTask(String taskName, String description,String status,Integer id) {
        Task newTask = new Task(taskName,description,status,id);
        tasksMap.put(id, newTask);
    }

    public HashMap getTasksMap() {
        return tasksMap;
    }

    public void deleteTaskById(Integer id) {
        tasksMap.remove(id);
    }


}


