package leetcode;

import java.util.Arrays;

public class leetcode001 {
    public static void main(String[] args) {
       Arrays.stream(twoSum(new int[]{3,2,4},6)).forEach(
                value -> System.out.println("  "+value)
        );
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] numresult=new int[2];
        for(int i=0;i<=nums.length-2;i++) {
            for (int j = i+1; j <= nums.length - 1; j++) {
                if (nums[i]+nums[j]==target){
                    numresult[0]=i;
                    numresult[1]=j;
                    break;
                }
            }
        }
        return numresult;
    }
}
