package linkedlists;

public class QuickSort {

    public static void main(String[] args) {
        LinkedListNode<Integer> tail = new LinkedListNode<>(12);
        LinkedListNode<Integer> head = new LinkedListNode<>(11, new LinkedListNode<>(6, new LinkedListNode<>(1, new LinkedListNode<>(44, tail))));
        head = quickSort(head, tail, head);
        printList(head);
    }

    private static LinkedListNode<Integer> quickSort(LinkedListNode<Integer> head, LinkedListNode<Integer> tail, LinkedListNode<Integer> actualHead) {
        if (head == null || tail == null || head == tail)
            return actualHead;
        DoubleNode<Integer> partitionNode = partition(head, tail);
        if (partitionNode.head.data < actualHead.data)
            actualHead = partitionNode.head;
        LinkedListNode<Integer> head1 = quickSort(partitionNode.head, partitionNode.tail, actualHead);
        if (head1.data < actualHead.data)
            actualHead = head1;
        if (partitionNode.tail != null && partitionNode.tail.next != null) {
            LinkedListNode<Integer> head2 = quickSort(partitionNode.tail.next.next, tail, actualHead);
            if (head2.data < actualHead.data)
                actualHead = head2;
        }
        return actualHead;
    }

    private static void printList(LinkedListNode<Integer> temp) {
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    private static DoubleNode<Integer> partition(LinkedListNode<Integer> head, LinkedListNode<Integer> tail) {
        if (head == tail)
            return new DoubleNode<>(null, null);
        LinkedListNode<Integer> newHead = head;
        LinkedListNode<Integer> prev = head;
        LinkedListNode<Integer> current = head.next;
        LinkedListNode<Integer> newTail = null;
        while (current != null && current != tail.next) {
            if (current.data <= head.data) {
                if (newTail == null)
                    newTail = current;
                prev.next = current.next;
                current.next = newHead;
                newHead = current;
                current = prev.next;
                continue;
            }
            prev = current;
            current = current.next;
        }
        return new DoubleNode<>(newHead, newTail);

    }
}
