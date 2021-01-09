package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class leetcode347 {
    public static void main(String[] args) {
        int[] x = topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        System.out.println("");
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] sum = new int[k];
        HashMap<Integer, Integer> countNs = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (countNs.containsKey(nums[i])) {
                int size = countNs.get(nums[i]);
                countNs.put(nums[i], size + 1);
            } else {
                countNs.put(nums[i], 1);
            }
        }
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : countNs.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }


//        //构造最大堆
//        if (countNs.size()<=k){
//
//        }
        int maxTimes = Integer.MIN_VALUE;
        for (Integer integer : countNs.values()) {
            if (integer > maxTimes) {
                maxTimes = integer;
            }
        }
        while (k > 0) {
            for (Map.Entry<Integer, Integer> entry : countNs.entrySet()) {
                if (entry.getValue() == maxTimes) {
                    sum[k-1] = entry.getKey();
                    k--;
                }
            }
            maxTimes--;
        }

        return sum;
    }

    static class MaxHeap {
        int[] nums;
        int k;

        public MaxHeap(int[] nums, int k) {
            this.nums = nums;
            this.k = k;
            buildHeap(nums, k);
        }

        private void buildHeap(int[] nums, int k) {
            for (int i = 0; i < (nums.length - 1) / 2; i++) {
                head(i, k);
            }
        }

        private void head(int i, int k) {


        }


        private int left(int index) {
            return (index + 1) >> 1;
        }

        private int right(int index) {
            return ((index + 1) >> 1) - 1;
        }

    }
}
