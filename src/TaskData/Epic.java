package TaskData;

import java.util.HashMap;

public class Epic extends Task{

    HashMap <Integer,Subtask> epics = new HashMap<>();
    public Epic(String taskName, String description,String status) {
        super(taskName, description,status);
    }

}
