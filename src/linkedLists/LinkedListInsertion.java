package linkedLists;

public class LinkedListInsertion {
    public static ListNode linked_list_intersection(ListNode head_A, ListNode head_B) {
        ListNode ptr_A = head_A;
        ListNode ptr_B = head_B;
        // Traverse through list A with 'ptr_A' and list B with 'ptr_B' until they meet.
        while (ptr_A != ptr_B) {
            // Traverse list A -> list B by first traversing 'ptr_A' and then, upon
            // reaching the end of list A, continue the traversal from the head of list B.
            ptr_A = (ptr_A != null) ? ptr_A.next : head_B;
            // Simultaneously, traverse list B -> list A.
            ptr_B = (ptr_B != null) ? ptr_B.next : head_A;
        }
        // At this point, 'ptr_A' and 'ptr_B' either point to the intersection node or both
        // are null if the lists do not intersect. Return either pointer.
        return ptr_A;
    }

    public static void main(String[] args) {
        // 🔸 Create common part: 8 -> 10
        ListNode common = new ListNode(8);
        common.next = new ListNode(10);

        // 🔸 List A: 3 -> 7 -> 8 -> 10
        ListNode head_A = new ListNode(3);
        head_A.next = new ListNode(7);
        head_A.next.next = common;

        // 🔸 List B: 99 -> 1 -> 8 -> 10
        ListNode head_B = new ListNode(99);
        head_B.next = new ListNode(1);
        head_B.next.next = common;

        // 🔸 Find intersection
        ListNode result = linked_list_intersection(head_A, head_B);

        // 🔸 Print result
        if (result != null) {
            System.out.println("Intersection at node: " + result.val);
        } else {
            System.out.println("No intersection");
        }
    }

}
