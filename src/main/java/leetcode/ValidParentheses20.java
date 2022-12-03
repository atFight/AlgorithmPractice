package leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ValidParentheses20 {

    private String link = "https://leetcode.cn/problems/valid-parentheses/";
    private String type = "Stack";

    @Test
    public void isValid() {
        String str = "](){}[][";
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (char c : str.toCharArray()) {
            if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.removeLast() != map.get(c)) {
                    System.out.println("false");
                    break;
                }
            }else {
                stack.offerLast(c);
            }
        }
        System.out.println(stack.isEmpty());
    }

}
