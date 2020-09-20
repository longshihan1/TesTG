package leetcode;

public class leetcode024 {
    public static void main(String[] args) {
        ListNode listNode=new ListNode(1);
        listNode.next=new ListNode(2);
        listNode.next.next=new ListNode(3);
        listNode.next.next.next=new ListNode(4);
        swapPairs(listNode);
         System.out.println("");
    }
    public static ListNode swapPairs(ListNode head) {
        // If the list has no node or has only one node left.
        if ((head == null) || (head.next == null)) {
            return head;
        }
        // Nodes to be swapped
        ListNode firstNode = head;
        ListNode secondNode = head.next;
        firstNode.next=swapPairs(secondNode.next);
        secondNode.next=firstNode;
        return secondNode;
    }
}
