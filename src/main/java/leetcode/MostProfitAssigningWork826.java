package leetcode;

import org.junit.Test;
import study.HeapAndPriorityQueueUtil;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class MostProfitAssigningWork826 {

//        int[] difficulty = new int[]{85,47,57};
//        int[] profit = new int[]{24,66,99};
//        int[] worker = new int[]{40,25,25};
//        int[] difficulty = new int[]{66,1,28,73,53,35,45,60,100,44,59,94,27,88,7,18,83,18,72,63};
//        int[] profit = new int[]{66,20,84,81,56,40,37,82,53,45,43,96,67,27,12,54,98,19,47,77};
//        int[] worker = new int[]{61,33,68,38,63,45,1,10,53,23,66,70,14,51,94,18,28,78,100,16};

    int binarySearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) >>> 1;
            int midVal = a[mid];
            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                break; // key found
        }
        return mid;
    }

    @Test
    public void maxProfitAssignment() {
        int[] difficulty = new int[]{2,4,6,8,10};
        int[] profit = new int[]{10,20,30,40,50};
        int[] worker = new int[]{4,5,6,7};

        Map<Integer, Integer> hashmap = new HashMap<>();
        for(int i = 0; i < difficulty.length; i++) {
            hashmap.put(difficulty[i], profit[i]);
        }
        Arrays.sort(difficulty);
        for (int i = 1 ; i < difficulty.length; i++) {
            if (hashmap.get(difficulty[i]) < hashmap.get(difficulty[i - 1])) {
                hashmap.put(difficulty[i], hashmap.get(difficulty[i - 1]));
            }
        }

        int ans = 0;
        for (int w : worker) {
            int mid = binarySearch(difficulty, w);
            if (mid >= 0 && difficulty[mid] > w) {
                mid = mid - 1;
            }
            int p = mid < 0 ? 0 : hashmap.get(difficulty[mid]);
            ans += p;
        }
        System.out.println(ans);
    }

//    private static final Comparator<int[]> cmp = (o1, o2) -> o1[0] - o2[0];

    // 官方题解
    @Test
    public void maxProfitAssignment2() {
        int[] difficulty = new int[]{2,4,6,8,10};
        int[] profit = new int[]{10,20,30,40,50};
        int[] worker = new int[]{4,5,6,7};

        List<int[]> jobs = new ArrayList<>();
        final int N = difficulty.length;
        for (int i = 0; i < N; i++) {
            jobs.add(new int[] {difficulty[i], profit[i]});
        }
        Comparator<int[]> cmp = Comparator.comparingInt(o -> o[0]);
        jobs.sort(cmp);
        Arrays.sort(worker);

        int i = 0, ans = 0, best = 0;
        for (int skill : worker) {
            while (i < N && skill >= jobs.get(i)[0]) {
                best = Math.max(best, jobs.get(i)[1]);
                i++;
            }
            ans += best;
        }
        System.out.println(ans);
    }

}
