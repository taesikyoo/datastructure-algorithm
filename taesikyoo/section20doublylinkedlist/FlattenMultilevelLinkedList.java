package section20doublylinkedlist;

import java.util.Stack;

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
            "val=" + val +
            '}';
    }
}

class FlattenMultilevelLinkedList {
    public static Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) { // 1->2->3
            Node removed = stack.pop();
            System.out.println(removed);
            if (removed.next != null) {
                stack.push(removed.next);
            }
            if (removed.child != null) {
                stack.push(removed.child);
            }
            removed.child = null;
            if (!stack.isEmpty()) {
                removed.next = stack.peek(); // 3 -> 7
                stack.peek().prev = removed; // 7 <- 3
            }
        }
        return head;
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
/*        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        n1.next = n2;
        n2.prev = n1;
        n1.child = n3;

        printList(n1);
        flatten(n1);
        printList(n1);*/

        // ---------------------------------------
        Node p1 = new Node(1);
        Node p2 = new Node(2);
        Node p3 = new Node(3);
        Node p4 = new Node(4);
        Node p5 = new Node(5);
        Node p6 = new Node(6);
        Node p7 = new Node(7);
        Node p8 = new Node(8);
        Node p9 = new Node(9);
        Node p10 = new Node(10);
        Node p11 = new Node(11);
        Node p12 = new Node(12);
        linkDoubly(p1, p2);
        linkDoubly(p2, p3);
        linkDoubly(p3, p4);
        linkDoubly(p4, p5);
        linkDoubly(p5, p6);
        p3.child = p7;
        linkDoubly(p7, p8);
        linkDoubly(p8, p9);
        linkDoubly(p9, p10);
        p8.child = p11;
        linkDoubly(p11, p12);

        printList(p1);
        flatten(p1);
        printList(p1);
    }

    private static void linkDoubly(Node p1, Node p2) {
        p1.next = p2;
        p2.prev = p1;
    }

}