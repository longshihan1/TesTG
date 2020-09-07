package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class leetcodez005 {
    public static void main(String[] args) {
        STACK stack = new STACK();
        for (int i = 0; i < 5; i++) {
            stack.put(i + "");
        }
        for (int i = 0; i <5; i++) {
             System.out.println(""+stack.get());
        }
    }

    public static void queue() {

    }

    static class STACK {
        Queue<String> queue = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();


        public void put(String a) {
            while (!queue.isEmpty()) {
                queue2.add(queue.poll());
            }
            queue.add(a);
            while (!queue2.isEmpty()) {
                queue.add(queue2.poll());
            }
        }

        public String get(){
            return queue.poll();
        }
    }


}
