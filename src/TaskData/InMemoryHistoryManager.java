package TaskData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {

    private Node<Task> head;
    private Node<Task> tail;
    private HashMap<Integer, Node<Task>> linkedHistory = new HashMap<>();

    private static class Node<Task> {

        private Node<Task> next;
        private Task current;
        private Node<Task> prev;

        private Node(Node<Task> prev, Task current, Node<Task> next) {
            this.current = current;
            this.next = next;
            this.prev = prev;
        }

        private Node(Task current) {
            this.current = current;
            this.next = null;
            this.prev = null;
        }

    }

    private void linkLast(Task current) {
        if (linkedHistory.size() == 0) {
            head = new Node<>(current);
            tail = head;
            linkedHistory.put(current.id, tail);
        } else if (linkedHistory.size() == 1) {
            final Node<Task> newNode = new Node<>(head, current, null);
            tail = newNode;
            head.next = newNode;
            linkedHistory.put(current.id, tail);
        } else if (linkedHistory.size() > 1) {
            final Node<Task> oldTail = tail;
            final Node<Task> newNode = new Node<>(oldTail, current, null);
            tail = newNode;
            oldTail.next = newNode;
            linkedHistory.put(current.id, tail);
        }
    }

    public List<Task> getHistory() {
        List<Task> linkedTasks = new ArrayList<>();
        Node<Task> currentTask = head;
        if (linkedHistory.size() >= 1) {
            for (int i = 0; i < linkedHistory.size(); i++) {
                Task task = currentTask.current;
                linkedTasks.add(task);
                currentTask = currentTask.next;
            }
        }
        return linkedTasks;
    }

    private void removeNode(Node<Task> node) {
        if (node.next == null) {
            Integer oldTailId = tail.current.id;
            final Node<Task> prev = tail.prev;
            if (prev != null) {
                prev.next = null;
            }
            tail = prev;
            linkedHistory.remove(oldTailId);
        } else if (node.prev == null) {
            Integer oldHeadId = head.current.id;
            final Node<Task> next = head.next;
            next.prev = null;
            head = next;
            linkedHistory.remove(oldHeadId);
        } else {
            Integer removedNodeId = node.current.id;
            node.prev.next = node.next;
            node.next.prev = node.prev;
            linkedHistory.remove(removedNodeId);
        }
    }

    @Override
    public void add(Task task) {
        if (linkedHistory.containsKey(task.id)) {
            removeNode(linkedHistory.get(task.id));
        }
        linkLast(task);
    }
    public void remove(Integer id) {
        if (linkedHistory.containsKey(id)) {
            removeNode(linkedHistory.get(id));
        }
    }

}
