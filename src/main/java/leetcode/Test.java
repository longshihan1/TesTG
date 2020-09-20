package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<List<Integer>> lists=combine(4,2);
        System.out.println("");
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }
        Deque<Integer> queue=new ArrayDeque<>();
        dfs(n,k,1,queue,res);
        return res;
    }

    private static void dfs(int n, int k, int i, Deque<Integer> queue, List<List<Integer>> res) {
        if (queue.size()==k){
            res.add(new ArrayList<>(queue));
            return;
        }
        for (int j = i; j <=n; j++) {
            queue.addLast(j);
            dfs(n, k, j+1, queue, res);
            queue.removeLast();
        }

    }
}
