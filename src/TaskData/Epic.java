package TaskData;

import java.util.HashMap;
import java.util.Map;

public class Epic extends Task{

    Map<Integer,Subtask> subtasks;

    public Epic (String taskName, String description, String status, Integer id) {
        super (taskName, description, status, id);
        subtasks = new HashMap<>();
    }

    @Override
    public String toString() {
        return "Epic{" +
                "taskName='" + taskName + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", subtasks=" + subtasks +
                '}';
    }
}
