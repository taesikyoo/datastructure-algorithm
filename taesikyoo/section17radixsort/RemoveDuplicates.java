package section17radixsort;

public class RemoveDuplicates {

    public static void main(String[] args) {
        ListNode tail = new ListNode(5);
        ListNode n1 = new ListNode(4, tail);
        ListNode n2 = new ListNode(4, n1);
        ListNode n3 = new ListNode(3, n2);
        ListNode n4 = new ListNode(3, n3);
        ListNode n5 = new ListNode(2, n4);
        ListNode head = new ListNode(1, n5);
        System.out.println(head);

        System.out.println(deleteDuplicates(head));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        if (head.val != head.next.val) {
            head.next = deleteDuplicates(head.next);
            return head;
        }

        while (head.next != null && head.val == head.next.val) {
            head = head.next;
        }

        return deleteDuplicates(head.next);
    }

    // Definition for singly-linked list.
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

        @Override
        public String toString() {
            if (next == null) {
                return String.valueOf(val);
            }
            return val + " -> " + next.toString();
        }
    }
}
