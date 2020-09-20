package leetcode;

import java.util.Arrays;
import java.util.List;

public class leetcodez014 {
    public void calTime(List<int[]> lists){
        int len = lists.get(0).length;
        int n = lists.size();
        int dp[] = new int[len];
        Arrays.fill(dp,Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            // 交给几号设备来处
            dp[0] = Math.min(dp[0],lists.get(i)[0]);
        }        // 取任
        for (int i = 1; i < len; i++) {
            // 交给几号设备来处
            for (int j = 0; j <n ; j++) {
                dp[i] = Math.min(dp[i-1]+lists.get(j)[i],dp[i]);
            }
        }

    }
}
