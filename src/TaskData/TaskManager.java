package TaskData;
import java.util.HashMap;
import java.util.List;

public interface TaskManager{
    HashMap<Integer,Task> tasksMap = new HashMap<>();
    HashMap<Integer,Epic> epicsMap = new HashMap<>();
    HashMap<Integer,Subtask> subtasksMap = new HashMap<>();

    public void createTask(String taskName, String description,TaskStatus status,Integer id) ;

    public HashMap getTasksMap();


    public void deleteTaskById(Integer id);

    public void createEpic(String taskName, String description,TaskStatus status,Integer id);
    public HashMap getEpicsMap();

    public void deleteEpicById(Integer id);

    public void createSubtask(String taskName, String description, TaskStatus status, Integer id,Integer epicId);
    public  void deleteSubtaskById(Integer epicId,Integer id);

    public void deleteAllTasks() ;


    public void deleteAllEpics() ;

    public Object getSubtasksOfEpic(Integer epicId) ;

    public void updateTask(String taskName, String description,TaskStatus status,Integer id);

    public void updateEpic(String taskName, String description,TaskStatus status,Integer id) ;

    public void updateSubtask(String taskName, String description, TaskStatus status, Integer id,Integer epicId) ;

    public void checkStatusOfEpic(Integer id) ;

    public void getTaskById(int id) ;

    public void getEpicById(int id) ;

    public void getSubtaskById(int id, int epicId) ;

}


