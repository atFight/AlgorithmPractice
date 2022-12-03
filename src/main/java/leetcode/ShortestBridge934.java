package leetcode;

import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestBridge934 {

    private String link = "https://leetcode.cn/problems/shortest-bridge/";
    private String type = "dfs + bfs + 记忆化搜索";


    //部分样例超时，官方解法不会 -.-
    //把其中一个小岛的标记改变
    //从另一个小岛出发
    //BFS找到最短的桥
    @Test
    public void shortestBridge() {

//        int[][] grid = new int[][]{{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}};
        int[][] grid = new int[][]{{0,1,0},{0,0,0},{0,0,1}};
//        int[][] grid = new int[][]{{0,1,0,0,0,0},{0,1,1,1,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{1,1,0,0,0,0}};
//        int[][] grid = new int[][]{{0,0,0,1,0,0,0,1},{0,0,0,1,1,0,1,1},{0,1,1,1,0,0,1,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}};

        int[][] direction = new int[][]{{0,1}, {1,0},{-1,0}, {0,-1}};
        int xLen = grid.length;
        int yLen = grid[0].length;
        Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();
        for (int i = 0;i < xLen && queue.isEmpty();i++) {
            for (int j = 0;j < yLen; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new Pair<>(i, j));
                    break;
                }
            }
        }

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            int i = pair.getKey();
            int j = pair.getValue();
            grid[i][j] = 2;
            for (int turn = 0;turn < 4; turn++) {
                int toX = i + direction[turn][0];
                int toY = j + direction[turn][1];
                if (toX < xLen && toX >= 0 && toY < yLen && toY >= 0 && grid[toX][toY] == 1) {
                    queue.add(new Pair<>(toX, toY));
                }
            }
        }

        for (int i = 0;i < xLen;i++) {
            for (int j = 0;j < yLen; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new Pair<>(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            int i = pair.getKey();
            int j = pair.getValue();
            for (int turn = 0;turn < 4; turn++) {
                int toX = i + direction[turn][0];
                int toY = j + direction[turn][1];
                if (toX < xLen && toX >= 0 && toY < yLen && toY >= 0
                        && grid[toX][toY] != 1) {
                    if (grid[i][j] == 1) {
                        grid[toX][toY] = -1;
                        queue.add(new Pair<>(toX, toY));
                    }else if(grid[toX][toY] <= 0){
                        if (grid[toX][toY] < grid[i][j] - 1 || grid[toX][toY] == 0) {
                            grid[toX][toY] = grid[i][j] - 1;
                            queue.add(new Pair<>(toX, toY));
                        }
                    }else if (grid[toX][toY] == 2) {
                        System.out.println("ans = " + Math.abs(grid[i][j]));
                        return;
                    }

                }
            }
        }
        System.out.println("end!");
    }

}
