
import java.util.*;

class Task {

    String name;
    int priority;

    Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return name + " (優先級: " + priority + ")";
    }
}

public class PriorityQueueWithHeap {

    private PriorityQueue<Task> queue;

    public PriorityQueueWithHeap() {
        // 大頂堆（優先級高的先出）
        queue = new PriorityQueue<>((a, b) -> b.priority - a.priority);
    }

    // 添加任務
    public void addTask(String name, int priority) {
        queue.add(new Task(name, priority));
    }

    // 執行優先級最高的任務
    public Task executeNext() {
        return queue.poll();
    }

    // 查看下一個要執行的任務
    public Task peek() {
        return queue.peek();
    }

    // 修改任務優先級
    public void changePriority(String name, int newPriority) {
        List<Task> temp = new ArrayList<>();
        boolean found = false;

        while (!queue.isEmpty()) {
            Task t = queue.poll();
            if (t.name.equals(name)) {
                t.priority = newPriority;
                found = true;
            }
            temp.add(t);
        }

        queue.addAll(temp);

        if (!found) {
            System.out.println("找不到任務: " + name);
        }
    }

    public static void main(String[] args) {
        PriorityQueueWithHeap pq = new PriorityQueueWithHeap();

        // 添加任務
        pq.addTask("備份", 1);
        pq.addTask("緊急修復", 5);
        pq.addTask("更新", 3);

        System.out.println("下一個要執行的任務: " + pq.peek());

        // 執行順序測試
        System.out.println("執行: " + pq.executeNext());
        System.out.println("執行: " + pq.executeNext());
        System.out.println("執行: " + pq.executeNext());
    }
}
