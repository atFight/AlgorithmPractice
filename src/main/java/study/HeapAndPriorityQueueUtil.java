package study;

import lombok.Data;
import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class HeapAndPriorityQueueUtil {
    @Data
    class Task {
        int priority;
        String name;

        Task(int priority) {
            this.priority = priority;
        }

    }

    // comparator implements
    private static final Comparator<Task> taskComparable = new Comparator<Task>() {
        @Override
        public int compare(Task t1, Task t2) {
            if (t1.getPriority() > t2.getPriority()) {
                return -1;
            }else if (t1.getPriority() < t2.getPriority()) {
                return 1;
            }
            return 0;
        }
    };

    @Test
    public void test() {
        // 仅存在Java.Util的Comparator的构造方法，不存在Java.Lang的Comparable构造方法
        Queue<Task> queue = new PriorityQueue<Task>(taskComparable);
        queue.add(new Task(123));
    }

}
