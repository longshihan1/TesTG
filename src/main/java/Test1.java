import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        List<String> d=new ArrayList<>();
        d= Collections.synchronizedList(d);

        System.out.println("XX:"
                +maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));

    }

    public static int maxSubArray(int[] nums){
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        int ans=nums[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] =Math.max(dp[i-1],0)+nums[i];
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}
