package leetcode;

public class leetcode121 {
    public static void main(String[] args) {
         System.out.println(""+maxProfit(new int[]{
                 7,6,4,3,1
         }));
    }
    public static int maxProfit(int[] prices) {
        if (prices.length<=1){
            return 0;
        }
        int[] s=new int[prices.length];
        s[0]=prices[0];
        int min=0;
        int minX=prices[0];
        for (int i = 1; i < prices.length; i++) {
            s[i]=prices[i]-minX;
            minX=Math.min(minX,prices[i]);
            if (s[i]>0){
                min=Math.max(min,s[i]);
            }
        }
        return min;
    }
}
