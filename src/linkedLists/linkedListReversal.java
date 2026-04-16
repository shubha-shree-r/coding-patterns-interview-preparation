package linkedLists;
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
public class linkedListReversal {
    public static ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseListRecursive(head.next);

        head.next.next = head; // reverse
        head.next = null;

        return newHead;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        head = reverseListRecursive(head);

        // Print reversed list
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
    }
}
