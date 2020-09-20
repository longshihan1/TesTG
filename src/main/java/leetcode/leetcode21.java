package leetcode;

public class leetcode21 {
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        l1.next=new ListNode(2);
        l1.next.next=new ListNode(4);
        ListNode l2=new ListNode(1);
        l2.next=new ListNode(3);
        l2.next.next=new ListNode(4);
        mergeTwoLists(l1,l2);
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null){
            return l2;
        }
        if (l2==null){
            return l1;
        }
        ListNode listNode=new ListNode();
        ListNode heasd=listNode;
        while (l1!=null||l2!=null){
            if (l1!=null&&l2!=null){
                if (l1.val<=l2.val){
                    heasd.next=new ListNode(l1.val);
                    heasd=heasd.next;
                    l1=l1.next;
                }else {
                    heasd.next=new ListNode(l2.val);
                    heasd=heasd.next;
                    l2=l2.next;
                }
            }else if (l1!=null){
                heasd.next=new ListNode(l1.val);
                heasd=heasd.next;
                l1=l1.next;
            }else {
                heasd.next=new ListNode(l2.val);
                heasd=heasd.next;
                l2=l2.next;
            }
        }
        return listNode.next;
    }
}
