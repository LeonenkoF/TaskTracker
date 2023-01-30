package TaskData;

import java.util.HashMap;
import java.util.Objects;

public class Storage {
    HashMap<Integer,Task> tasksMap = new HashMap<>();
    HashMap<Integer,Epic> epicsMap = new HashMap<>();
    HashMap<Integer,Subtask> subtasksMap = new HashMap<>();

    public Storage() {

    }
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

    public void createEpic(String taskName, String description,String status,Integer id){
        Epic newEpic = new Epic(taskName,description,status,id);
        epicsMap.put(id,newEpic);
    }
    public HashMap getEpicsMap() {
        return epicsMap;
    }

    public void deleteEpicById(Integer id){
        epicsMap.remove(id);

    }

    public void createSubtask(String taskName, String description, String status, Integer id,Integer epicId){
        Subtask newSubtask = new Subtask(taskName,description,status,id,epicId);
        epicsMap.get(epicId).subtasks.put(id,newSubtask);
        checkStatusOfEpic(epicId);
    }

    public  void deleteSubtaskById(Integer epicId,Integer id){
        epicsMap.get(epicId).subtasks.remove(id);
    }

    public void deleteAllTasks() {
        tasksMap.clear();
    }

    public void deleteAllEpics() {
        epicsMap.clear();
    }

    public Object getSubtasksOfEpic(Integer epicId) {
        return epicsMap.get(epicId).subtasks.values();
    }

    public void updateTask(String taskName, String description,String status,Integer id) {
        Task newTask = new Task(taskName,description,status,id);
        tasksMap.replace(id, newTask);
    }

    public void updateEpic(String taskName, String description,String status,Integer id) {
        Epic rewriteEpic;
        rewriteEpic = epicsMap.get(id);
        rewriteEpic.taskName = taskName;
        rewriteEpic.description = description;
        rewriteEpic.status = status;
        rewriteEpic.id = id;
        epicsMap.replace(id,rewriteEpic);
        checkStatusOfEpic(id);
    }

    public void updateSubtask(String taskName, String description, String status, Integer id,Integer epicId) {
        Subtask newSubtask = new Subtask(taskName,description,status,id,epicId);
        epicsMap.get(epicId).subtasks.replace(id,newSubtask);
        checkStatusOfEpic(epicId);
    }

    public void checkStatusOfEpic(Integer id) {
        int counter = 0;
        for (Subtask subtask : epicsMap.get(id).subtasks.values()){
            if (subtask.status.equals("IN_PROGRESS")) {
                epicsMap.get(id).status = "IN_PROGRESS";
            } else if (subtask.status.equals("DONE")){
                counter++;
            }
            if (counter > 0 && counter < epicsMap.get(id).subtasks.size()){
                epicsMap.get(id).status = "IN_PROGRESS";
            } else if (counter == epicsMap.get(id).subtasks.size()){
                epicsMap.get(id).status = "DONE";
            } else {
                epicsMap.get(id).status = "NEW";
            }
        }
    }

    public void getTaskById(int id) {
        tasksMap.get(id);

    }

    public void getEpicById(int id) {
        epicsMap.get(id);
    }

    public void getSubtaskById(int id, int epicId) {
        epicsMap.get(epicId).subtasks.get(id);
    }
}


