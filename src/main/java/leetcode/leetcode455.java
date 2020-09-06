package leetcode;

import java.util.Arrays;

public class leetcode455 {
    public static void main(String[] args) {
        System.out.println("" + findContentChildren(new int[]{1, 2}, new int[]{}));

    }

    public static int findContentChildren(int[] g, int[] s) {
        if (g.length == 0 || s.length == 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0, si = 0;
        while (gi < g.length && si < s.length) {
            if (g[gi] <= s[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }
}
