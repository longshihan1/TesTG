package leetcode;

public class leetcode002 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(3);
        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);
        ListNode listNode1 = addTwoNumbers(listNode, listNode2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode result = new ListNode((l1.val + l2.val) % 10);
        int jinwei = (l1.val + l2.val) / 10;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null && l2 != null) {
            int current = l1.val + l2.val + jinwei;
            ListNode temp = result;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode(current % 10);
            jinwei = current / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int current = l1.val + jinwei;
            ListNode temp = result;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode(current % 10);
            jinwei = current / 10;
            l1 = l1.next;
        }
        while (l2 != null) {
            int current = l2.val + jinwei;
            ListNode temp = result;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode(current % 10);
            jinwei = current / 10;
            l2 = l2.next;
        }
        if (jinwei == 1) {
            ListNode temp = result;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode(1);
        }
        return result;
    }


    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }
}
