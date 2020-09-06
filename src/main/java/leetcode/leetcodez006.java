package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class leetcodez006 {
    public static void main(String[] args) {

        int[] sum=new int[]{72,6,57,88,60,42,83,73,48,85};
        //快排
//        quickSortMin(sum,0,sum.length-1);
        //堆排

//        Minheap minheap=new Minheap(sum,sum.length);
//        Maxheap maxheap=new Maxheap(sum,sum.length);
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        for (int i = 0; i <sum.length; i++) {
//            pq.add(sum[i]);
//        }
//        while (!pq.isEmpty()) {
//            System.out.print(pq.poll() + ", ");
//        }
        // 合并排序
        merge_Sort(sum);
        System.out.println(""+Arrays.toString(sum));

    }

    //快排-从小到大
    public static void quickSortMax(int[] sum,int leftIndex,int rightIndex){
        if (leftIndex>=rightIndex){
            return;
        }
        int left=leftIndex;
        int right=rightIndex;
        int min=sum[left];
        while (left<right){
            while (left<right&&sum[right]>=min){
               right--;
            }
            sum[left]=sum[right];
            while (left<right&&sum[left]<=min){
                left++;
            }
            sum[right]=sum[left];

        }
        sum[left]=min;
        quickSortMax(sum,leftIndex,left-1);
        quickSortMax(sum,left+1,rightIndex);
    }
    //快排-从大到小
    public static void quickSortMin(int[] sum,int leftIndex,int rightIndex){
        if (leftIndex>=rightIndex){
            return;
        }
        int left=leftIndex;
        int right=rightIndex;
        int min=sum[left];
        while (left<right){
            while (left<right&&sum[right]<min){
                right--;
            }
            sum[left]=sum[right];
            while (left<right&&sum[left]>min){
                left++;
            }
            sum[right]=sum[left];

        }
        sum[left]=min;
        quickSortMin(sum,leftIndex,left-1);
        quickSortMin(sum,left+1,rightIndex);
    }

    static class Minheap{
        int[] data;

        public Minheap(int[] data,int k) {
            this.data = data;
            heap(data,k);
        }

        private void heap(int[] data, int k) {
            for (int i =data.length/2-1;i>=0; i--) {
                heapMin(i,k);
            }
        }

        private void heapMin(int i, int k) {
            int left=left(i);
            int right=right(i);
            int min=i;
            if (right<k&&data[right]<data[min]){
                min=right;
            }
            if (left<k&&data[left]<data[min]){
                min=left;
            }
            if (min==i) return;
            swap(i,min);
            heapMin(min,k);
        }



        private void swap(int left,int right){
            int temp=data[left];
            data[left]=data[right];
            data[right]=temp;
        }
        private int right(int left){
            return (left+1)<<1;
        }
        private int left(int right){
            return ((right+1)<<1 )-1;
        }

        public int[] getData() {
            return data;
        }

        public int getRoot(){
            return data[0];
        }
        public void setRoot(int root){
            data[0] = root;
            heapMin(0, data.length);
        }
    }

    static class Maxheap{
        int[] data;

        public Maxheap(int[] data,int k) {
            this.data = data;
            heap(data,k);
        }

        private void heap(int[] data, int k) {
            for (int i =data.length/2-1;i>=0; i--) {
                heapMin(i,k);
            }
        }

        private void heapMin(int i, int k) {
            int left=left(i);
            int right=right(i);
            int min=i;
            if (right<k&&data[right]>data[min]){
                min=right;
            }
            if (left<k&&data[left]>data[min]){
                min=left;
            }
            if (min==i) return;
            swap(i,min);
            heapMin(min,k);
        }



        private void swap(int left,int right){
            int temp=data[left];
            data[left]=data[right];
            data[right]=temp;
        }
        private int right(int left){
            return (left+1)<<1;
        }
        private int left(int right){
            return ((right+1)<<1 )-1;
        }

        public int[] getData() {
            return data;
        }

        public int getRoot(){
            return data[0];
        }
        public void setRoot(int root){
            data[0] = root;
            heapMin(0, data.length);
        }
    }

    static void merge_Sort(int[] arr){
        int length = arr.length;
        int mid = length/2;
        if(length > 1){
            int[] left = Arrays.copyOfRange(arr, 0, mid);//复制左半部分
            int[] right = Arrays.copyOfRange(arr, mid, length);//复制右半部分
            merge_Sort(left);//递归左边
            merge_Sort(right);//递归右边
            merge(arr,left,right);//合并数组
        }
    }

    static void merge(int[] result, int[] left, int[] right) {
        int i = 0, l = 0, r = 0;
        while(l < left.length && r < right.length){
            if(left[l] < right[r] )
                result[i++] = left[l++];
            else
                result[i++] = right[r++];
        }
        while(l < left.length){//若left数组剩余，则后面依次复制给result
            result[i++] = left[l++];
        }
        while(r < right.length){//反之
            result[i++] = right[r++];
        }
    }

    public static void merge1(int[] result,int[] left,int[] right){

        int i=0,l=0,r=0;
        while (l<left.length&&r<right.length){
            if (left[l]<right[r]){
                result[i++]=left[l--];
            }else {
                result[i++]=right[r++];
            }
        }
        while (l<left.length){
            result[i++]=left[l++];
        }
        while(r < right.length){//反之
            result[i++] = right[r++];
        }
    }
}
