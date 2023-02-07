package TaskData;

import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager{

    List<Task> history = new ArrayList<>();

    public void add(Task task) {


        final Integer historySize = 10;

        history.add(task);

        if(history.size()>historySize) history.remove(11);

    }

    public List<Task> getHistory() {
        return history;
    }
}
