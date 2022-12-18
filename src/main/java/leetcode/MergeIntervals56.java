package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals56 {

    @Test
    public void merge() {
        int[][] intervals = new int[][]{{1,3}, {2,6},{8,10},{15,18}};

        final int N = intervals.length;
        Arrays.sort(intervals, ((o1, o2) -> (o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0])));
        int[] cur = new int[]{intervals[0][0], intervals[0][1]};
        List<int[]> ans = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            if (intervals[i][0] <= cur[1]) {
                if (intervals[i][1] > cur[1]) {
                    cur[1] = intervals[i][1];
                }
            }else {
                ans.add(new int[]{cur[0], cur[1]});
                cur[0] = intervals[i][0];
                cur[1] = intervals[i][1];
            }
        }
        ans.add(new int[]{cur[0], cur[1]});
        int[][] res = ans.toArray(new int[ans.size()][]);

        System.out.println(res.toString());

    }

}
