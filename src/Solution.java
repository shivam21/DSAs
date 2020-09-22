
class Node {
    int val;
    Node next;

    Node(int x, Node next) {
        val = x;
        this.next = next;
    }

    public Node(int i) {
        val = i;
    }
}

class Solution {

    public static Node removeLoop(Node head) {
        Node slow = head;
        Node fast = head;
        while (slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                int lengthLoop = lenLoop(slow);
                removeLoop(head, lengthLoop);
                break;
            }
        }
        return head;
    }

    static int lenLoop(Node slow) {
        int size = 1;
        Node current = slow.next;
        while (current != slow) {
            size++;
            current = current.next;
        }
        return size;
    }

    static void removeLoop(Node head, int lengthLoop) {
        Node p1 = head;
        Node p2 = head;
        for (int i = 0; i < lengthLoop; i++) {
            p2 = p2.next;
        }
        Node prev = null;
        while (p1 != p2) {
            prev = p2;
            p1 = p1.next;
            p2 = p2.next;
        }
        if (prev != null)
            prev.next = null;

    }
}