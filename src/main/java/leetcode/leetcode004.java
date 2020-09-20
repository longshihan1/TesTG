package leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class leetcode004 {
    public static void main(String[] args) {
        System.out.println("  "+findMedianSortedArrays(new int[]{1,1},new int[]{1,2}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if ((m + n) % 2 != 0) // odd
            return (double) findKth(nums1, nums2, (m + n) / 2, 0, m - 1, 0, n - 1);
        else { // even
            return (findKth(nums1, nums2, (m + n) / 2, 0, m - 1, 0, n - 1)
                    + findKth(nums1, nums2, (m + n) / 2 - 1, 0, m - 1, 0, n - 1)) * 0.5;
        }
    }

    public static int findKth(int nums1[], int nums2[], int k,
                              int aStart, int aEnd, int bStart, int bEnd) {

        int aLen = aEnd - aStart + 1;
        int bLen = bEnd - bStart + 1;

        // Handle special cases
        if (aLen == 0)
            return nums2[bStart + k];
        if (bLen == 0)
            return nums1[aStart + k];
        if (k == 0)
            return nums1[aStart] < nums2[bStart] ? nums1[aStart] : nums2[bStart];

        int aMid = aLen * k / (aLen + bLen); // a's middle count
        int bMid = k - aMid - 1; // b's middle count

        // make aMid and bMid to be array index
        aMid = aMid + aStart;
        bMid = bMid + bStart;

        if (nums1[aMid] > nums2[bMid]) {
            k = k - (bMid - bStart + 1);
            aEnd = aMid;
            bStart = bMid + 1;
        } else {
            k = k - (aMid - aStart + 1);
            bEnd = bMid;
            aStart = aMid + 1;
        }

        return findKth(nums1, nums2, k, aStart, aEnd, bStart, bEnd);
    }
}
