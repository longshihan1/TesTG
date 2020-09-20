package leetcode;

public class leetcode070 {
    public static void main(String[] args) {
        System.out.println("  "+climbStairs(3));
    }
    public static int climbStairs(int n) {
        if (n==1||n==2){
            return n;
        }
        int[] sum=new int[n+1];
        sum[1]=1;
        sum[2]=2;
        for (int i = 3; i <sum.length; i++) {
            sum[i]=sum[i-1]+sum[i-2];
        }
        return sum[n];
    }
}
