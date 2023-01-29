package TaskData;

import java.util.HashMap;
import java.util.Map;

public class Epic extends Task{

    Map<Integer,Subtask> subtasks;

    public Epic(String taskName, String description, String status, Integer id, HashMap<Integer, Subtask> epics) {
        super(taskName, description, status, id);
        subtasks= new HashMap<>();
    }

    @Override
    public String toString() {
        return "Epic{" +
                "subtasks=" + subtasks +
                ", taskName='" + taskName + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
