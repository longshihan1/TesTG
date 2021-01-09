package leetcode;

public class leetcode042 {
    public static void main(String[] args) {
         System.out.println(""+trap(new int[]{
                 0,1,0,2,1,0,1,3,2,1,2,1
         }));
    }

    public static int trap(int[] height) {
        int max=0;
        int start=0;
        int end=height.length-1;
        int left_max = 0, right_max = 0;
        while (start<end){
                if (height[start] < height[end]) {
                    if (height[start] >= left_max) {
                        left_max = height[start];
                    } else {
                        max += (left_max - height[start]);
                    }
                    start++;
                } else {
                    if (height[end] >= right_max) {
                        right_max = height[end];
                    } else {
                        max += (right_max - height[end]);
                    }
                    end--;
                }

        }
        return max;
    }
}
