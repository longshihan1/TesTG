package budy;

public class s {

    static class MinHeap {
        private int[] data;

        public MinHeap(int[] data) {
            this.data = data;
            buildHeap(data.length);
        }

        public void buildHeap(int heapSize) {
            for (int i = heapSize / 2 - 1; i >= 0; i--) {
                heapify(i, heapSize);
            }
        }

        public void heapify(int index, int heapSize) {
            int left = left(index);
            int right = right(index);
            int min = index;
            if (left < heapSize && data[right] < data[index]) {
                min = right;
            }
            if (left < heapSize && data[left] < data[index]) {
                min = left;
            }
            if (left == min) {
                return;
            }
            swap(index, min);
            heapify(min, heapSize);


        }

        private void swap(int index1, int index2) {
            int tmp = data[index1];
            data[index1] = data[index2];
            data[index2] = tmp;
        }

        private int right(int index) {
            return (index + 1) << 1;
        }

        private int left(int index) {
            return ((index + 1) << 1) - 1;
        }
    }
}
