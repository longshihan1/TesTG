package leetcode;

public class leetcode203 {
    public static void main(String[] args) {
        ListNode head2=new ListNode();
        ListNode h=head2;
//        for (int i = 1; i <7; i++) {
//            h.next=new ListNode(i);
//            h=h.next;
//        }
        head2.next=new ListNode(1);
        head2.next.next=new ListNode(1);
        removeElements(head2.next,1);
    }
    public static ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode prev = sentinel, curr = head;
        while (curr != null) {
            if (curr.val == val) prev.next = curr.next;
            else prev = curr;
            curr = curr.next;
        }
        return sentinel.next;
    }
}
