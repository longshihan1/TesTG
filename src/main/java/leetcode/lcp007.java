package leetcode;


import java.util.Deque;
import java.util.LinkedList;

public class lcp007 {
    public static void main(String[] args) {
        int[][] nums={{0,2},{2,1}};
        System.out.println(" "+numWays(3,nums,2));
    }
    public static int numWays(int n, int[][] relation, int k) {
        Deque<Integer> currentIndex=new LinkedList<>();
        currentIndex.add(0);
        return dfs(n,relation,k,currentIndex,0);
    }

    public static int dfs(int n, int[][] relation, int k, Deque<Integer> currentList,int count){
        if (count==k){
            int result=0;
            while (currentList.size()>0){
                if (currentList.pollFirst()==n-1){
                    result+=1;
                }
            }
            return result;
        }else {
            int size = currentList.size();
            for (int i = 0; i < size; i++) {
                int tempPop = currentList.pop();
                for (int j = 0; j < relation.length; j++) {
                    int[] temp = relation[j];
                    if (tempPop == temp[0]) {
                        currentList.addLast(temp[1]);
                    }
                }
            }
          return dfs(n, relation, k, currentList, count+1);
        }
    }
}
