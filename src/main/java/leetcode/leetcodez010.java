package leetcode;

public class leetcodez010 {
    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {
        int currMaxSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currMaxSum = Math.max(currMaxSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, currMaxSum);
        }
        return maxSum;
    }
    public int maxSubArray1(int[] nums){

        int max=nums[0];
        int sum=max;
        for (int i = 1; i <nums.length; i++) {
            sum=Math.max(nums[i]+sum,nums[i]);
            max=Math.max(max,sum);
        }
        return max;
    }
}
