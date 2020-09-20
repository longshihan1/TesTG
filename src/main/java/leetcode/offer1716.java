package leetcode;

public class offer1716 {
    public static void main(String[] args) {
        System.out.println("" + massage(new int[]{
                2,7,9,3,1
        }));
    }

    public static int massage(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] s = new int[nums.length];
        s[0] = nums[0];
        s[1] = Math.max(nums[0], nums[1]);
        if (nums.length == 2) {
            return s[1];
        }
        int max = s[1];
        for (int i = 2; i < nums.length; i++) {
            s[i] = Math.max(s[i - 2] + nums[i], s[i - 1]);
            max = Math.max(max, s[i]);
        }
        return max;
    }
}
