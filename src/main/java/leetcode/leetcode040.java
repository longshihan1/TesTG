package leetcode;

import java.util.*;

public class leetcode040 {

    public static void main(String[] args) {
        List<List<Integer>> res=combinationSum2(new int[]{10,1,2,7,6,1,5},8);
        System.out.println("  ");
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res=new ArrayList<>();
        Deque<Integer> deque=new ArrayDeque<>();
        Set<String> strings=new TreeSet<>();
        dfs(candidates,target,0,deque,res,strings);
        return res;
    }

    private static void dfs(int[] candidates, int target, int begin, Deque<Integer> deque, List<List<Integer>> res, Set<String> strings) {
        if (target<0){
            return;
        }else if (target==0){
            List<Integer> tempList=new ArrayList<>(deque);
            String tempStr=tempList.toString();
            if (!strings.contains(tempStr)) {
                strings.add(tempStr);
                res.add(tempList);
            }
            return;
        }else {
            for (int i = begin; i <candidates.length; i++) {
                deque.addLast(candidates[i]);
                dfs(candidates, target-candidates[i], i+1, deque, res, strings);
                deque.removeLast();
            }
        }

    }

}
