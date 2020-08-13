package leetcode;

public class leetcode011 {
    public static void main(String[] args) {
        System.out.println("  " + maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int area = 0;
        while (left < right) {
            if (height[left] > height[right]) {
                area =  Math.max(area,height[right] * (right - left));
                right--;
            } else {
                area = Math.max(area,height[left] * (right - left));
                left++;
            }
        }
        return area;
    }
}
