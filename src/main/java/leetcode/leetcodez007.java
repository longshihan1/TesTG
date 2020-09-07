package leetcode;

public class leetcodez007 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(3);
        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);
        ListNode listNode1 = addTwoNumbers(listNode, listNode2);
         System.out.println("");
    }

    private static ListNode addTwoNumbers(ListNode listNode, ListNode listNode2) {
        int temp=0;
        ListNode listNode1=new ListNode(0);
        ListNode curr=listNode1;
        while (listNode!=null||listNode2!=null) {
            int x = (listNode != null) ? listNode.val : 0;
            int y = (listNode2 != null) ? listNode2.val : 0;
            int x1 = x + y + temp;
            temp = x1 / 10;
            curr.next = new ListNode(x1%10);
            curr = curr.next;
            if (listNode != null) {
                listNode = listNode.next;
            }
            if (listNode2 != null) {
                listNode2 = listNode2.next;
            }
        }
        if (temp>0){
            curr.next = new ListNode(1);
        }
        return listNode1.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }
    
}
