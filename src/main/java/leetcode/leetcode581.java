package leetcode;

public class leetcode581 {
    public static void main(String[] args) {
         System.out.println(""+findUnsortedSubarray(new int[]{
                1,3,2,2
         }));
    }

    public static int findUnsortedSubarray(int[] nums) {
        if (nums.length==0||nums.length==1){
            return 0;
        }
        int start=0;
        int end=nums.length-1;
        boolean isStart=false;
        boolean isEnd=false;
        while (start<end){
            if (isStart&&isEnd){
                break;
            }
            if (nums[start]<=nums[start+1]){
                start++;
            }else {
                isStart=true;
            }
            if (nums[end]>=nums[end-1]){
                end--;
            }else {
                isEnd=true;
            }

        }
        return end-start==0?0:end-start+1;
    }
}
