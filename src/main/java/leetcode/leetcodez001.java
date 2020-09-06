package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcodez001 {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);

        Node.reverseK(node,3);
        Node test = new Node(0);
        Node cur = test;
        for (int i = 1; i < 3; i++) {
            cur.next=new Node(i);
            cur = cur.next;
        }
    }




    static class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
        public Node() {
        }

        public static Node reverse(Node head) {
            if (head == null) {
                return null;
            }
            Node pre = null;
            Node cur = head;
            Node aft = head.next;
            while (aft != null) {
                cur.next = pre;
                pre = cur;
                cur = aft;
                aft = aft.next;
            }
            cur.next = pre;
            return cur;
        }

        public static Node reverseK(Node head, int k) {
            List<CutRes> cutResList = new ArrayList<>();
            while (head != null) {
                CutRes cutRes = cut(head, k);
                cutResList.add(cutRes);
                head = cutRes.newHead;
            }
            Node cur = new Node();
            Node pre = cur;
            for (CutRes cutRes : cutResList) {
                cur.next = Node.reverse(cutRes.head);
                cur = cutRes.head;
            }
            return pre.next;
        }

        /**
         * 从头部切割链表
         *
         * @param head 原头部
         * @param k    切割长度
         */
        public static CutRes cut(Node head, int k) {
            if (k <= 0) {
                return new CutRes(null, head);
            }
            Node cur = head;
            int i = 0;
            while (cur.next != null && ++i < k) {
                cur = cur.next;
            }
            Node tail = cur;
            Node newHead = cur.next;
            tail.next = null;
            return new CutRes(head, newHead);
        }

        static class CutRes {
            Node head; //切割得到的头部
            Node newHead; //切割后剩余的头部

            public CutRes(Node head, Node newHead) {
                this.head = head;
                this.newHead = newHead;
            }

            @Override
            public String toString() {
                return head.toString();
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            Node cur = next;
            sb.append(val);
            while (cur != null) {
                sb.append(", ");
                sb.append(cur.val);
                cur = cur.next;
            }
            sb.append(']');
            return sb.toString();
        }
    }

}
