package linkedLists;

public class RemoveKthLastNode {
    public static ListNode remove_kth_last_node(ListNode head, int k) {
        // A dummy node to ensure there's a node before 'head' in case we need to remove
        // the head node.
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode trailer = dummy;
        ListNode leader = dummy;
        // Advance 'leader' k steps ahead.
        for (int i = 0; i < k; i++) {
            leader = leader.next;
            // If k is larger than the length of the linked list, no node needs to be
            // removed.
            if (leader == null) {
                return head;
            }
        }
        // Move 'leader' to the end of the linked list, keeping 'trailer' k nodes behind.
        while (leader.next != null) {
            leader = leader.next;
            trailer = trailer.next;
        }
        // Remove the kth node from the end.
        trailer.next = trailer.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(7);
        int target = 2;

        head = remove_kth_last_node(head,target);

        // Print reversed list
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
    }
}
