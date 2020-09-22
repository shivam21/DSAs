package linkedlists;

public class ReverseListRec {
    public static void main(String[] args) {
        LinkedListNode<Integer> head = reverseListRec(new LinkedListNode<>(2, new LinkedListNode<>(3, new LinkedListNode<>(4, new LinkedListNode<>(5)))));
        printList(head);
    }

    private static LinkedListNode<Integer> reverseListRec(LinkedListNode<Integer> head) {
        if (head == null || head.next == null)
            return head;
        LinkedListNode<Integer> tail = head.next;
        head.next=null;
        LinkedListNode<Integer> newHead = reverseListRec(tail);
        tail.next = head;
        return newHead;
    }

    private static void printList(LinkedListNode<Integer> temp) {
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
