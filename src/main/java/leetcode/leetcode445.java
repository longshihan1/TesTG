package leetcode;

public class leetcode445 {
    public static void main(String[] args) {
        ListNode listNode=new ListNode(5);
//        listNode.next=new ListNode(2);
//        listNode.next.next=new ListNode(4);
//        listNode.next.next.next=new ListNode(3);
        ListNode listNode2=new ListNode(5);
//        listNode2.next=new ListNode(6);
//        listNode2.next.next=new ListNode(4);
        ListNode dd=addTwoNumbers(listNode,listNode2);
         System.out.println("");
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node=new ListNode();
        ListNode head=node;
        l1=reverNode(l1);
        l2=reverNode(l2);
        int temp=0;
        while (l1!=null||l2!=null){
            int sum=temp;
            if (l1!=null&&l2!=null){
                sum+=l1.val+l2.val;
                l1=l1.next;
                l2=l2.next;
            }else if (l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }else if (l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }
            head.next=new ListNode(sum%10);
            head=head.next;
            temp=sum/10;
        }
        if (temp!=0){
            head.next=new ListNode(temp);
        }
        node=reverNode(node.next);
        return node;
    }

    public static ListNode reverNode(ListNode node){
        ListNode listNode=new ListNode();
        while (node!=null){
            ListNode temp=listNode.next;
            listNode.next=new ListNode(node.val);
            listNode.next.next=temp;
            node=node.next;
        }
        return listNode.next;
    }

}
