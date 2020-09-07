package leetcode;

public class leetcode021 {
    public static void main(String[] args) {
//        1->2->4, 1->3->4
        ListNode listNode1=new ListNode(1);
        listNode1.next=new ListNode(2);
        listNode1.next.next=new ListNode(4);
        ListNode listNode2=new ListNode(1);
        listNode2.next=new ListNode(3);
        listNode2.next.next=new ListNode(4);
        System.out.println("  "+mergeTwoLists(listNode1,listNode2));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null){
            return l2;
        }
        if (l2==null){
            return l1;
        }
        ListNode listNode=new ListNode(0);
        ListNode tmp = listNode;
        while (l1!=null&&l2!=null){
            if (l1.val>= l2.val){
                tmp.next=l1;
                l2=l2.next;
                tmp=tmp.next;
            }else {
                tmp.next=l1;
                l1=l1.next;
                tmp=tmp.next;
            }
        }
        if (l1==null){
            listNode.next=l2;
        }
        if (l2==null){
            listNode.next=l1;
        }
        return listNode.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
