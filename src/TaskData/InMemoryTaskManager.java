package TaskData;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class InMemoryTaskManager implements TaskManager{
    HashMap<Integer,Task> tasksMap = new HashMap<>();
    HashMap<Integer,Epic> epicsMap = new HashMap<>();
    HashMap<Integer,Subtask> subtasksMap = new HashMap<>();

    HistoryManager historyManager = Managers.getDefaultHistory();

    public void createTask(String taskName, String description,TaskStatus status,Integer id) {
        Task newTask = new Task(taskName,description,TaskStatus.NEW,id);
        tasksMap.put(id, newTask);
    }

    public HashMap getTasksMap() {
        return tasksMap;
    }

    public void deleteTaskById(Integer id) {
        tasksMap.remove(id);
    }

    public void createEpic(String taskName, String description,TaskStatus status,Integer id){
        Epic newEpic = new Epic(taskName,description,TaskStatus.NEW,id);
        epicsMap.put(id,newEpic);
    }
    public HashMap getEpicsMap() {
        return epicsMap;
    }

    public void deleteEpicById(Integer id){
        epicsMap.remove(id);

    }

    public void createSubtask(String taskName, String description, TaskStatus status, Integer id,Integer epicId){
        Subtask newSubtask = new Subtask(taskName,description,TaskStatus.NEW,id,epicId);
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

    public void updateTask(String taskName, String description,TaskStatus status,Integer id) {
        Task newTask = new Task(taskName,description,TaskStatus.NEW,id);
        tasksMap.replace(id, newTask);
    }

    public void updateEpic(String taskName, String description,TaskStatus status,Integer id) {
        Epic rewriteEpic;
        rewriteEpic = epicsMap.get(id);
        rewriteEpic.taskName = taskName;
        rewriteEpic.description = description;
        rewriteEpic.status = status;
        rewriteEpic.id = id;
        epicsMap.replace(id,rewriteEpic);
        checkStatusOfEpic(id);
    }

    public void updateSubtask(String taskName, String description, TaskStatus status, Integer id,Integer epicId) {
        Subtask newSubtask = new Subtask(taskName,description,TaskStatus.NEW,id,epicId);
        epicsMap.get(epicId).subtasks.replace(id,newSubtask);
        checkStatusOfEpic(epicId);
    }

    public void checkStatusOfEpic(Integer id) {
        int counter = 0;
        for (Subtask subtask : epicsMap.get(id).subtasks.values()){
            if (subtask.status.equals(TaskStatus.IN_PROGRESS)) {
                epicsMap.get(id).status = TaskStatus.IN_PROGRESS;
            } else if (subtask.status.equals(TaskStatus.DONE)){
                counter++;
            }
            if (counter > 0 && counter < epicsMap.get(id).subtasks.size()){
                epicsMap.get(id).status = TaskStatus.IN_PROGRESS;
            } else if (counter == epicsMap.get(id).subtasks.size()){
                epicsMap.get(id).status = TaskStatus.DONE;
            } else {
                epicsMap.get(id).status = TaskStatus.NEW;
            }
        }
    }

    public void getTaskById(int id) {
        tasksMap.get(id);
      historyManager.add(tasksMap.get(id));

    }

    public void getEpicById(int id) {
        epicsMap.get(id);
        historyManager.add(epicsMap.get(id));
    }

    public void getSubtaskById(int id, int epicId) {
        epicsMap.get(epicId).subtasks.get(id);
        historyManager.add(epicsMap.get(epicId).subtasks.get(id));
    }

    public List<Task> getHistory(){
        return historyManager.getHistory();

    }
}