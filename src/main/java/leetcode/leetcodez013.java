package leetcode;

public class leetcodez013 {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
      Node v=  revise(node);
         System.out.println("");
    }

    public static Node revise(Node node){
        Node temp=new Node();
        while (node!=null){
            Node node1=new Node(node.val);
            node1.next=temp.next;
            temp.next=node1;
            node=node.next;
        }
        return temp.next;
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

    static class Node{
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node() {

        }
    }
}
