import linkedlists.LinkedListNode;

public class Runerr {
    public static void main(String[] args) {
        Node tail = new Node(16);
        Node next = new Node(58, new Node(36, new Node(34, tail)));
        tail.next = next;
        Node head = new Node(7, next);
        head = Solution.removeLoop(head);
        printList(head);
    }

    private static void printList(Node temp) {
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
