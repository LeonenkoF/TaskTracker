package TaskData;

import java.util.HashMap;
import java.util.Objects;

public class Subtask extends Task{

    public Integer epicId;

    public Subtask(String taskName, String description, String status, Integer id, Integer epicId) {
        super(taskName, description, status, id);
        this.epicId=epicId;
    }

    @Override
    public String toString() {
        return "Subtask{" + "\n" +
                "taskName=" + taskName + "\n" +
                "description=" + description + "\n" +
                "status=" + status +
                '}'+ "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subtask subtask = (Subtask) o;
        return Objects.equals(epicId, subtask.epicId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(epicId);
    }
}
