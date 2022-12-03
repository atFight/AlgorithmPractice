package leetcode;

import org.junit.Test;

public class CountAndSay38 {

    private String link = "https://leetcode.cn/problems/count-and-say/";

    public String getStr(String str){
        int size = str.length();
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (i < size) {
            int cnt = 1;
            for (int j = i + 1;j < size; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    cnt++;
                }else {
                    break;
                }
            }
            stringBuilder.append(String.valueOf(cnt)).append(str.charAt(i + cnt - 1));
            i = i + cnt;
        }
        return stringBuilder.toString();
    }

    @Test
    @SuppressWarnings("all")
    public void countAndSay() {
        int n = 8;
        if (n == 1) {
            System.out.println("1");
        }

        String ans = "1";
        for (int i = 0; i < n - 1;i++) {
            ans = getStr(ans);
        }
        System.out.println(ans);
    }
}
