package leetcode;

public class leetcode198 {
    public static void main(String[] args) {
        System.out.println(""+rob(new int[]{2,7,9,3,1}));
    }

    public static int rob(int[] nums) {
        int n= nums.length;
        if (n==0){
            return 0;
        }
        if (n==1){
            return nums[0];
        }

        int[] count=new int[n];
        count[0]=nums[0];
        count[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            count[i]=Math.max(count[i-1],count[i-2]+nums[i]);
        }
        return count[n-1];
    }
}
