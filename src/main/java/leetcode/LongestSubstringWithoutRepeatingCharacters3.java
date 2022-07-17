package leetcode;

import org.junit.Test;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters3 {

    private String link = "https://leetcode.cn/problems/longest-substring-without-repeating-characters/";
    private String type = "双指针+哈希表";

    //当时不熟悉Set集合
    //假如Set没有字母x，则x入Set，右指针++
    //假如Set存在字母x，判断长度Max(max,now)，左指针++，直到x的位置
    @Test
    public void lengthOfLongestSubstring() {
        String str = "pwwkew";
        Character[] charObjectArray = str.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
        Map<Character, Integer> recordMap = new HashMap<>();
        int head = 0, tail = 1, ans = 1;

        recordMap.put(charObjectArray[head], 1);
        while (tail < charObjectArray.length) {
            if (recordMap.get(charObjectArray[tail]) != null) {
                recordMap.put(charObjectArray[tail], recordMap.get(charObjectArray[tail]) + 1);
            }else {
                recordMap.put(charObjectArray[tail], 1);
            }

            while (head < tail && recordMap.get(charObjectArray[tail]) > 1) {
                recordMap.put(charObjectArray[head], recordMap.get(charObjectArray[head]) - 1);
                head++;
            }
            tail++;
            ans = Math.max(ans, tail - head);
        }

        System.out.println(ans);
    }

    //官方答案
    public int lengthOfLongestSubstring2(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

}
