package study;

import lombok.Data;

import java.util.Comparator;

public class HeapAndPriorityQueueUtil {

    public int num;

    @Data
    class Task2 {
        int priority;
        String name;
    }

    // comparator implements
    private static Comparator<Task2> taskComparable = new Comparator<Task2>() {
        @Override
        public int compare(Task2 t1, Task2 t2) {
            if (t1.getPriority() > t2.getPriority()) {
                return -1;
            }else if (t1.getPriority() < t2.getPriority()) {
                return 1;
            }
            return 0;
        }
    };

    // heap operations

}
