package leetcode;

import org.junit.Test;

import java.util.*;

public class KDiffPairsInAnArray532 {

    private String link = "https://leetcode.cn/problems/k-diff-pairs-in-an-array/";

    @Test
    public void function() {
        int[] nums = new int[]{3, 1, 4, 1, 5};
        int k = 2;
        findPairs(nums, k);
        findPairsByLeetcode(nums, k);
    }

    public void findPairs(int[] nums, int k) {
        Map<Integer, Integer> recordMap = new HashMap();
        Arrays.sort(nums);
        for (int i = 0;i < nums.length;i++) {
            int j = i + 1;
            while (j < nums.length && nums[j] - nums[i] <= k) {
                if (nums[j] - nums[i] == k) {
                    recordMap.put(nums[i], nums[j]);
                }
                j++;
            }
        }
        System.out.println(recordMap.size());
    }

    //更好地利用到了HashSet去重的特性
    public void findPairsByLeetcode(int[] nums, int k) {
        Set<Integer> visited = new HashSet<Integer>();
        Set<Integer> res = new HashSet<Integer>();
        for (int num : nums) {
            if (visited.contains(num - k)) {
                res.add(num - k);
            }
            if (visited.contains(num + k)) {
                res.add(num);
            }
            visited.add(num);
        }
        System.out.println(res.size());
    }
}
