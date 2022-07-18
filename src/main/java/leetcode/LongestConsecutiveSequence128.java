package leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class LongestConsecutiveSequence128 {

    private String link = "https://leetcode.cn/problems/longest-consecutive-sequence/";
    private String type = "哈希表";


    /*
    * 思路：存在TreeSet，集合元素有序
    * 全部元素add到集合中，并找出最小数
    * 从最小数开始遍历，如果next = cur + 1 的话，连续counter+1
    *
    * 弊端：TreeSet add元素时时间复杂度为log n，所以总体时间复杂度为nlogn
    * 官方解法用hashSet实现时间复杂度为n的做法
    * */
    @Test
    public void longestConsecutive() {
        int[] nums = new int[]{100,4,200,1,3,2};
        TreeSet<Integer> treeSet = new TreeSet<>();
        int minNum = nums[0];
        for (int num : nums) {
            minNum = Math.min(num, minNum);
            treeSet.add(num);
        }
        Integer next;
        int ans = 0;
        int cur = 0;
        while ((next = treeSet.higher(minNum)) != null) {
            if (next == minNum+1) {
                cur++;
            }else {
                ans = Math.max(ans, cur + 1);
                cur = 0;
            }
            minNum = next;
        }
        ans = Math.max(ans, cur + 1);
        System.out.println(ans);
    }

    /*
    * 官方解法
    *
    我们考虑枚举数组中的每个数 xx，考虑以其为起点，不断尝试匹配 x+1, x+2, \cdotsx+1,x+2,⋯ 是否存在，假设最长匹配到了 x+yx+y，那么以 xx 为起点的最长连续序列即为 x, x+1, x+2, \cdots, x+yx,x+1,x+2,⋯,x+y，其长度为 y+1y+1，我们不断枚举并更新答案即可。
    对于匹配的过程，暴力的方法是 O(n)O(n) 遍历数组去看是否存在这个数，但其实更高效的方法是用一个哈希表存储数组中的数，这样查看一个数是否存在即能优化至 O(1)O(1) 的时间复杂度。
    仅仅是这样我们的算法时间复杂度最坏情况下还是会达到 O(n^2)（即外层需要枚举 O(n)O(n) 个数，内层需要暴力匹配 O(n)次），无法满足题目的要求。但仔细分析这个过程，我们会发现其中执行了很多不必要的枚举，如果已知有一个 x, x+1, x+2, \cdots, x+yx,x+1,x+2,⋯,x+y 的连续序列，而我们却重新从 x+1x+1，x+2x+2 或者是 x+yx+y 处开始尝试匹配，那么得到的结果肯定不会优于枚举 xx 为起点的答案，因此我们在外层循环的时候碰到这种情况跳过即可。
    那么怎么判断是否跳过呢？由于我们要枚举的数 xx 一定是在数组中不存在前驱数 x-1x−1 的，不然按照上面的分析我们会从 x-1x−1 开始尝试匹配，因此我们每次在哈希表中检查是否存在 x-1x−1 即能判断是否需要跳过了。
    作者：LeetCode-Solution
    链接：https://leetcode.cn/problems/longest-consecutive-sequence/solution/zui-chang-lian-xu-xu-lie-by-leetcode-solution/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    *
    * */
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
