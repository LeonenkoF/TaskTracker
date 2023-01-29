package TaskData;

public class Task {
    public Integer id;
    public String taskName;
    public String description;
    public String status = "NEW";

    public Task(String taskName, String description,String status,Integer id) {
        this.taskName = taskName;
        this.description = description;
        this.status = status;
        this.id=id;
    }

    public Integer getId() {
        return id;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskName='" + taskName + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
