package linkedlists;

public class MergeSort {
    public static void main(String[] args) {
        LinkedListNode<Integer> tail = new LinkedListNode<>(12);
        LinkedListNode<Integer> head = new LinkedListNode<>(11, new LinkedListNode<>(6, new LinkedListNode<>(1, new LinkedListNode<>(44, tail))));
        head = mergeSort(head);
        printList(head);
    }

    private static LinkedListNode<Integer> mergeSort(LinkedListNode<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedListNode<Integer> mid = findMid(head);
        LinkedListNode<Integer> head1 = mergeSort(head);
        LinkedListNode<Integer> head2 = mergeSort(mid);
        return merge(head1, head2);
    }

    private static LinkedListNode<Integer> merge(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
        LinkedListNode<Integer> head = null;
        LinkedListNode<Integer> headTop = null;
        while (head1 != null & head2 != null) {
            if (head1.data <= head2.data) {
                if (head == null) {
                    head = head1;
                    headTop = head1;
                } else {
                    head.next = head1;
                    head = head.next;
                }
                head1 = head1.next;
            } else {
                if (head == null) {
                    head = head2;
                    headTop = head2;
                } else {
                    head.next = head2;
                    head = head.next;
                }
                head2 = head2.next;
            }
        }
        if (head1 == null && head2 != null) {
            if (head != null) {
                head.next = head2;
            } else {
                return head2;
            }
        }
        if (head1 != null) {
            if (head != null) {
                head.next = head1;
            } else {
                return head1;
            }
        }
        return headTop;
    }

    private static LinkedListNode<Integer> findMid(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        LinkedListNode<Integer> next = null;
        if (slow != null) {
            next = slow.next;
            slow.next = null;
        }
        return next;
    }

    private static void printList(LinkedListNode<Integer> temp) {
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
