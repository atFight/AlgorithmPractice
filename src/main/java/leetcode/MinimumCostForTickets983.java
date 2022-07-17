package leetcode;

import org.junit.Test;

//https://leetcode.cn/problems/minimum-cost-for-tickets/
//dp
/*
    在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。

    火车票有 三种不同的销售方式 ：

    一张 为期一天 的通行证售价为 costs[0] 美元；
    一张 为期七天 的通行证售价为 costs[1] 美元；
    一张 为期三十天 的通行证售价为 costs[2] 美元。
    通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张 为期 7 天 的通行证，那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。

    返回 你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费 。

    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/minimum-cost-for-tickets
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class MinimumCostForTickets983 {
    @Test
    public void mincostTickets() {
        int[] days = new int[]{1,4,6,9,10,11,12,13,14,15,16,17,18,20,21,22,23,27,28};
        int[] costs = new int[]{3,13,45};
        int[] dpArr = new int[366];

        int lastDay = 0;
        for (int day: days) {
            for (int j = lastDay + 1; j < day; j++) {
                dpArr[j] = dpArr[lastDay];
            }

            int ticket2 = costs[0] + (day <= 1 ? 0 : dpArr[day - 1]);
            int ticket7 = costs[1] + (day <= 7 ? 0 : dpArr[day - 7]);
            int ticket30 = costs[2] + (day <= 30 ? 0 : dpArr[day - 30]);
            dpArr[day] = Math.min(ticket2, Math.min(ticket7, ticket30));
            lastDay = day;
        }
        System.out.println(dpArr[days[days.length - 1]]);
    }

}
