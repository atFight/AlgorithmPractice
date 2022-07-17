package offer.hwod;

import org.junit.Test;

import java.util.Stack;


public class FirstTechnicalInterview {

    /*
        现给一个符合此速记方式的字符串 records，请以字符串形式返回复原后的内容。
        注： records 仅由小写字母、数字及<, >, (, )组成。

        示例 1：
        输入：records = "abc(d)<2>e"
        输出："abcdde"
        解释：字符串中出现 "(d)<2>"，表示 "d" 重复出现 2 次，因此返回复原后的内容 "abcdde"。

        示例 2：
        输入：records = "a(b(c)<3>d)<2>e"
        输出："abcccdbcccde"
        解释：字符串中出现 "a(b(c)<3>d)<2>"，其中 "(c)<3>" 表示 "c" 出现 3 次，复原为 "ccc"；"(bcccd)<2>" 表示 "bcccd" 重复出现 2 次，复原为 "bcccdbcccd"。最终返回复原后内容 "abcccdbcccde"

        提示：
        ·1 <= records.length <= 200
        ·2 <= 重复次数 <= 10
        ·题目保证返回结果字符串长度小于等于 10^4
        ·输入保证合法，确保括号与尖括号成对出现
        ·嵌套深度不超过 13

     */


    public String unzipString(String records) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i< records.length(); i++) {
            if (records.charAt(i) == '>') {
                StringBuilder repeatBuilder = new StringBuilder();
                StringBuilder strBuilder = new StringBuilder();
                int repeatTime = 0;
                while (!stack.peek().equals("<")) {
                    repeatBuilder.append(stack.pop());
                }
                repeatTime = Integer.parseInt(repeatBuilder.reverse().toString());
                stack.pop();
                stack.pop();

                while (!stack.peek().equals("(")) {
                    strBuilder.append(stack.pop());
                }
                stack.pop();
                while (repeatTime > 0) {
                    stack.push(strBuilder.toString());
                    repeatTime--;
                }
            }else {
                stack.push(String.valueOf(records.charAt(i)));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            String tmp = stack.pop();
            stringBuilder.append(tmp);
        }
        return  stringBuilder.reverse().toString();
    }

    @Test
    public void test() {
        System.out.println(unzipString("a(b(c)<3>d)<2>e"));
    }

}
