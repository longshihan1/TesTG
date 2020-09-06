package leetcode;

import java.util.*;

public class leetcodez004 {
    public static void main(String[] args) {
        int[] arrTopK = {72,6,57,88,60,42,83,73,48,85};
        int k = arrTopK.length;
        //创建一个大小为k的数组
        int[] data = new int[k];
        for(int i = 0; i < k; i ++){
            data[i] = arrTopK[i];
        }
        MinHeap heap = new MinHeap(data);
        for(int i = k; i < arrTopK.length; i ++){
            //如果大于堆顶的元素则替换顶并重新构造
            if(arrTopK[i] > heap.getRoot()) heap.setRoot(arrTopK[i]);
        }
        //打印最大的k个数
        for(int i = 0; i < k; i ++){
            System.out.println(data[i]);
        }

    }
    //最小堆类
    static class MinHeap{
        private int[] data;
        public MinHeap(int[] data){
            this.data = data;
            buildHeap(data.length);
        }

        public void buildHeap(int heapSize){
            for(int i = heapSize / 2 - 1; i >= 0;i --){
                heapify(i, heapSize);
            }
        }

        public void heapify(int index,int heapSize){
            int right = right(index);
            int left = left(index);
            int min = index;
            if(right < heapSize && data[right] < data[min]) min = right;
            if(left < heapSize && data[left] < data[min]) min = left;
            if(min ==index) return;
            swap(index,min);
            heapify(min,heapSize);
        }

        private int right(int index){
            //右儿子的下标
            return (index + 1) << 1;
        }

        private int left(int index){
            //左儿子的下标
            return ((index + 1) << 1) - 1;
        }

        public void swap(int index1,int index2){
            int tmp = data[index1];
            data[index1] = data[index2];
            data[index2] = tmp;
        }

        public int getRoot(){
            return data[0];
        }

        public void setRoot(int root){
            data[0] = root;
            heapify(0, data.length);
        }
    }

}
