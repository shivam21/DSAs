package test;

import linkedlists.Node;

public class DeleteAlternate {

    public static void deleteAlternateNodes(Node<Integer> head) {
        if (head == null || head.next == null) {
            return;
        }
        while (head != null && head.next != null) {
            head.next = head.next.next;
            head = head.next;
        }
    }

}
