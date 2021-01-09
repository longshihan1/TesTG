package leetcode;

public class offer24 {
    public static void main(String[] args) {
        ListNode node=new ListNode();
        ListNode head=node;
        for (int i = 1; i <=10; i++) {
            head.next=new ListNode(i);
            head=head.next;
        }
        reverseList(node.next);
    }
    public static ListNode reverseList(ListNode head) {
        ListNode headNode=head;
       head=head.next;
        headNode.next=null;
        while (head!=null){
            ListNode temp=head.next;
            head.next=headNode;
            headNode=head;
            head=temp;
        }
        return headNode;
    }
}
