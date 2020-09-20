package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class leetcode216 {
    public static void main(String[] args) {
        combinationSum3(3,9);
    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res=new ArrayList<>();
        int[] num=new int[]{1,2,3,4,5,6,7,8,9};
        Deque<Integer> deque=new ArrayDeque<>();
        dfs(num,n,0,deque,res,k);
        return res;
    }

    private static void dfs(int[] num, int sum, int begin, Deque<Integer> deque, List<List<Integer>> res, int k) {
        if (deque.size()>k){
            return;
        }
        if (sum<0){
            return;
        }else if (sum==0&&deque.size()==k){
            res.add(new ArrayList<>(deque));
            return;
        }else {
            for (int i = begin; i <num.length; i++) {
                deque.addLast(num[i]);
                dfs(num, sum-num[i], i+1, deque, res, k);
                deque.removeLast();
            }
        }
    }
}
