package test;

import linkedlists.LinkedListNode;

public class Test {
    public static LinkedListNode<Integer> nextLargeNumber(LinkedListNode<Integer> head) {
        if (head == null)
            return null;
        LinkedListNode<Integer> reverseHeadTop = reverseList(head);
        LinkedListNode<Integer> reverseHead = reverseHeadTop;
        LinkedListNode<Integer> prev = null;
        while (reverseHead != null && reverseHead.data == 9) {
            reverseHead.data = 0;
            prev = reverseHead;
            reverseHead = reverseHead.next;
        }
        if (reverseHead == null) {
            LinkedListNode<Integer> newNode = new LinkedListNode<>(1);
            if (prev != null) {
                prev.next = newNode;
            } else {
                reverseHeadTop = newNode;
            }
        } else {
            reverseHead.data = reverseHead.data + 1;
        }
        return reverseList(reverseHeadTop);
    }

    private static LinkedListNode<Integer> reverseList(LinkedListNode<Integer> head) {
        if (head == null || head.next == null)
            return head;
        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> current = head;
        LinkedListNode<Integer> next = head.next;
        while (next != null) {
            current.next = prev;
            prev = current;
            current = next;
            next = next.next;
        }
        current.next = prev;
        return current;

    }
}
