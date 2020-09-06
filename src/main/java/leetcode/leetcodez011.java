package leetcode;

public class leetcodez011 {
    public static void main(String[] args) {
        count(4);
    }

    public static void count(int n){
        Node head=new Node();
        Node cur=head;
        int k=3;
        for (int i = 1; i <=n; i++) {
            Node node=new Node(i);
            cur.next=node;
            cur=node;
        }
        cur.next=head.next;

        Node p=head.next;
        while (p.next!=p){
            for (int i = 1; i <k-1; i++) {
                p=p.next;
            }
            p.next=p.next.next;
            p=p.next;
        }
         System.out.println(""+p.val);
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
