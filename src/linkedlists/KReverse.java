package linkedlists;

public class KReverse {

    public static LinkedListNode<Integer> kReverse(LinkedListNode<Integer> head, int k) {
        if (k == 0||head == null)
            return head;
        int i = 1;
        LinkedListNode<Integer> current = head;
        while (current != null) {
            if (i == k) {
                LinkedListNode<Integer> nh = current.next;
                current.next = null;
                LinkedListNode<Integer> lh = reverseList(head);
                head.next = kReverse(nh, k);
                return lh;
            }
            i++;
            current = current.next;
        }
        return head;
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
