package TaskData;

public class Task {
    public Integer id;
    public String taskName;
    public String description;
    public TaskStatus status = TaskStatus.NEW;

    public Task(String taskName, String description,TaskStatus status,Integer id) {
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

    public TaskStatus getStatus() {
        return status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" + "\n" +
                "taskName=" + taskName + "\n" +
                "description=" + description + "\n" +
                "status=" + status + "\n" +
                '}';
    }
}
