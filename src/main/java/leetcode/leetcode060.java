package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode060 {
    public static void main(String[] args) {
         System.out.println(""+getPermutation(9,10));
    }
    public static String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for( int i = 1; i <= n; i++ ) {
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while( n > 0 ) {
            int curCom = cal(--n);
            int group = (k-1)/curCom;
            sb.append(list.get(group));
            list.remove(group);
            k -= (group*curCom);
        }
        return sb.toString();
    }

    private static int cal(int num) {
        int res = 1;
        for( int i = 1; i <= num; i++ ) {
            res *= i;
        }
        return res;
    }

}
