package linkedlists;

public class DetectRemoveLoop {
    public static void main(String[] args) {
        LinkedListNode<Integer> tail = new LinkedListNode<>(5);
        LinkedListNode<Integer> next = new LinkedListNode<>(3, new LinkedListNode<>(4, tail));
        LinkedListNode<Integer> head = new LinkedListNode<>(2, next);
        tail.next = next;
        detectRemoveLoop(head);
        printList(head);
    }

    private static void detectRemoveLoop(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head;
        while (slow != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                int lengthLoop = lenLoop(slow);
                removeLoop(head, lengthLoop);
                break;
            }
        }
    }

    private static int lenLoop(LinkedListNode<Integer> slow) {
        int size = 1;
        LinkedListNode<Integer> current = slow.next;
        while (current != slow) {
            size++;
            current = current.next;
        }
        return size;
    }

    private static void removeLoop(LinkedListNode<Integer> head, int lengthLoop) {
        LinkedListNode<Integer> p1 = head;
        LinkedListNode<Integer> p2 = head;
        for (int i = 0; i < lengthLoop; i++) {
            p2 = p2.next;
        }
        LinkedListNode<Integer> prev = null;
        while (p1 != p2) {
            prev = p2;
            p1 = p1.next;
            p2 = p2.next;
        }
        if (prev != null)
            prev.next = null;

    }

    private static void printList(LinkedListNode<Integer> temp) {
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
