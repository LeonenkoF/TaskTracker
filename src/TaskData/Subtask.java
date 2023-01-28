package TaskData;

import java.util.HashMap;

public class Subtask extends Task{

    HashMap<Integer,Task> subtasks = new HashMap<>();
    public Subtask(String taskName, String description, String status) {
        super(taskName, description,status);
    }
}
