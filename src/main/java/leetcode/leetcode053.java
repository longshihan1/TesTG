package leetcode;

public class leetcode053 {
    public static void main(String[] args) {
         System.out.println(""+maxSubArray(new int[]{
                 -1,-2
         }));
    }
    public static int maxSubArray(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        if (nums.length==1){
            return nums[0];
        }
        int[] s=new int[nums.length];
        s[0]=nums[0];
        int max=s[0];
        for (int i = 1; i < nums.length; i++) {
            s[i]=Math.max(s[i-1]+nums[i],nums[i]);
            max=Math.max(max,s[i]);
        }
        return max;
    }
}
