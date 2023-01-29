package TaskData;

import java.util.HashMap;

public class Subtask extends Task{

    public Integer epicId;

    public Subtask(String taskName, String description, String status, Integer id, HashMap<Integer, Task> subtasks, Integer epicId) {
        super(taskName, description, status, id);
        this.epicId=epicId;
    }

    @Override
    public String toString() {
        return "Subtask{" +
                ", taskName='" + taskName + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
