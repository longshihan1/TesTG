package leetcode;

public class leetcode061 {
    public static void main(String[] args) {

    }
    public static ListNode rotateRight(ListNode head, int k) {
        if (head==null||head.next==null){
            return head;
        }
        if (k==0){
            return head;
        }
        while (head!=null){
            head=head.next;
        }

        return head;
    }
}
