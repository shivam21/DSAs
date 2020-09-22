package linkedlists;

public class EvenAfterOdd {
    public static void main(String[] args) {
        printList(sortEvenOdd(new LinkedListNode<>(1, new LinkedListNode<>(2, new LinkedListNode<>(3, new LinkedListNode<>(4, new LinkedListNode<>(5)))))));
    }

    public static LinkedListNode<Integer> sortEvenOdd(LinkedListNode<Integer> head) {
        if (head == null || head.next == null)
            return head;

        LinkedListNode<Integer> current = head;
        LinkedListNode<Integer> even = null;
        LinkedListNode<Integer> odd = null;
        LinkedListNode<Integer> oddTop = null;
        LinkedListNode<Integer> eventTop = null;
        while (current != null) {
            if (current.data % 2 == 0) {
                if (even == null) {
                    even = current;
                    eventTop = current;
                } else {
                    even.next = current;
                    even = even.next;
                }

            } else {
                if (odd == null) {
                    odd = current;
                    oddTop = current;
                } else {
                    odd.next = current;
                    odd = odd.next;
                }

            }
            current = current.next;
        }
        if (even != null) {
            even.next = null;
        }
        if (odd != null) {
            odd.next = eventTop;
            return oddTop;
        }
        return eventTop;


    }

    private static void printList(LinkedListNode<Integer> temp) {
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
