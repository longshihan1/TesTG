package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class leetcode077 {

    public static void main(String[] args) {
        List<List<Integer>> lists=combine(4,2);
         System.out.println("");
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }
        // 从 1 开始是题目的设定
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, 1, path, res);
        return res;
    }

    private static void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size()==k){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int j = begin; j <=n; j++) {
            path.addLast(j);
            dfs(n, k, j+1, path, res);
            path.removeLast();
        }
    }
}
