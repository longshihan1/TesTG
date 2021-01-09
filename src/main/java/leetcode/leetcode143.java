package leetcode;

public class leetcode143 {
    public static void main(String[] args) {
        ListNode node=new ListNode();
        ListNode head=node;
        for (int i = 1; i <=10; i++) {
            head.next=new ListNode(i);
            head=head.next;
        }
        reorderList(node.next);

    }
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        //找中点，链表分成两个
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        //第二个链表倒置
        newHead = reverseList(newHead);
//链表节点依次连接
        while (newHead != null) {
            ListNode temp = newHead.next;
            newHead.next = head.next;
            head.next = newHead;
            head = newHead.next;
            newHead = temp;
        }
    }

    private static ListNode reverseList(ListNode head) {
        //本地翻转
        if (head == null) {
            return null;
        }
        ListNode tail = head;
        head = head.next;
        tail.next = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = tail;
            tail = head;
            head = temp;
        }

        return tail;
    }


}
