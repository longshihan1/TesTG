package leetcode;

public class leetcode523 {
    public static void main(String[] args) {

         System.out.println(""+checkSubarraySum(new int[]{23,2,4,6,7},6));
    }
    public static boolean checkSubarraySum(int[] nums, int k) {
        int[] dp = new int[10010];
        if(nums.length < 2) return false;

        if(k == 0){
            for(int i = 0; i < nums.length; i++){
                for(int j = 0; j < nums.length-i; j++){
                    dp[j] = (dp[j]+nums[j+i]);
                    if(i != 0 && dp[j] == 0) return true;
                }
            }
            return false;
        }
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length-i; j++){
                dp[j] = (dp[j]+nums[j+i]) % k;
                if(i != 0 && dp[j] == 0) return true;
            }
        }
        return false;
    }
}
