package leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SimplifyPath71 {

    private String link = "https://leetcode.cn/problems/simplify-path/";
    private String type = "队列 + 字符串处理";

    @Test
    public void simplifyPath() {
        String path = "/a/./b/../../c/";
        StringBuilder stringBuilder = new StringBuilder();
        List<String> list = new ArrayList<>();
        String[] paths = path.split("/");

        for (String p : paths) {
            if (p == null || p.length() == 0 || p.equals(".")) {
                continue;
            }

            if (!p.equals("..")) {
                list.add("/" + p);
            }else if (!list.isEmpty()) {
                list.remove(list.size() - 1);
            }
        }

        for (String str : list) {
            stringBuilder.append(str);
        }
        System.out.println((stringBuilder.length() == 0 ? "/" : stringBuilder.toString()));
    }
}
