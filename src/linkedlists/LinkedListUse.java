package linkedlists;


public class LinkedListUse {
    public static void main(String[] args) {
        LinkedListNode<Integer> head = reverse_R(new LinkedListNode<>(3, new LinkedListNode<>(1, new LinkedListNode<>(2, new LinkedListNode<>(5, new LinkedListNode<>(4))))));
        printList(head);
    }

    private static void printList(LinkedListNode<Integer> temp) {
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static LinkedListNode<Integer> reverse_R(LinkedListNode<Integer> head) {
        return reverse_R_Double(head).head;
    }

    public static DoubleNode<Integer> reverse_R_Double(LinkedListNode<Integer> head) {
        if (head == null || head.next == null)
            return new DoubleNode<Integer>(head, head);
        DoubleNode<Integer> newPair = reverse_R_Double(head.next);
        LinkedListNode<Integer> outputHead = newPair.head;
        LinkedListNode<Integer> outputTail = newPair.tail;
        outputTail.next = head;
        head.next = null;
        return new DoubleNode<Integer>(outputHead, head);
    }

    private static LinkedListNode<Integer> findMid(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        LinkedListNode<Integer> next = slow.next;
        slow.next = null;
        return next;
    }

    private static LinkedListNode<Integer> merge(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;
        LinkedListNode<Integer> newHeadTop = null;
        LinkedListNode<Integer> newHead = null;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                if (newHead == null) {
                    newHead = head1;
                    newHeadTop = newHead;
                } else {
                    newHead.next = head1;
                    newHead = head1;
                }
                head1 = head1.next;
            } else {
                if (newHead == null) {
                    newHead = head2;
                    newHeadTop = newHead;
                } else {
                    newHead.next = head2;
                    newHead = head2;
                }
                head2 = head2.next;
            }
        }
        if (head1 != null)
            newHead.next = head1;
        if (head2 != null)
            newHead.next = head2;
        return newHeadTop;
    }
}

class DoubleNode<T> {
    LinkedListNode<T> head;
    LinkedListNode<T> tail;

    public DoubleNode(LinkedListNode<T> head, LinkedListNode<T> tail) {
        this.head = head;
        this.tail = tail;
    }
}