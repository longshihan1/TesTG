package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class leetcode039 {

    public static void main(String[] args) {
        List<List<Integer>> listList=combinationSum(new int[]{2,3,5,7},7);
        System.out.println("  ");
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        if (candidates==null||candidates.length==0){
            return res;
        }

        Deque<Integer> deque=new ArrayDeque<>();
        dfs(candidates, target,0,deque,res);
        return res;
    }


    public static void dfs(int[] candidates, int target,int begin, Deque<Integer> deque, List<List<Integer>> res){
        int currentTmp = 0;
        List<Integer> integers=new ArrayList<>(deque);
        for (int i = 0; i <integers.size(); i++) {
            currentTmp+=integers.get(i);
        }
        if (currentTmp==target){
            res.add(integers);
            return;
        }
        if (currentTmp<target) {
            for (int i = begin; i < candidates.length; i++) {
                deque.addLast(candidates[i]);
                dfs(candidates, target, i, deque, res);
                deque.removeLast();
            }
        }

    }

    public static void dfs1(int[] candidates, int target,int begin, Deque<Integer> deque, List<List<Integer>> res){
        if (target<0){
            return;
        }else if (target==0){
            res.add(new ArrayList<>(deque));
            return;
        }else {
            for (int i = begin; i <candidates.length; i++) {
                deque.addLast(candidates[i]);
                dfs1(candidates,target-candidates[i],i,deque,res);
                deque.removeLast();
            }
        }
    }
}
