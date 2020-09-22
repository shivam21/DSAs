package linkedlists;

public class InsertRec {

    public static void main(String[] args) {
        insertNode(new LinkedListNode<Integer>(2, new LinkedListNode<>(5, new LinkedListNode<>(8, new LinkedListNode<>(12)))), 10, 4);
    }

    private static void insertNode(LinkedListNode<Integer> head, int element, int pos) {
        printList(insertNode(head,head, element, pos, 1));
    }

    private static void printList(LinkedListNode<Integer> temp) {
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    private static LinkedListNode<Integer> insertNode(LinkedListNode<Integer> top,LinkedListNode<Integer> head, int element, int pos, int index) {
        if (pos == 0) {
            LinkedListNode<Integer> newNode = new LinkedListNode<>(element);
            newNode.next = head;
            return newNode;
        }

        if (pos == index) {
            LinkedListNode<Integer> newNode = new LinkedListNode<>(element);
            newNode.next = head.next;
            head.next = newNode;
            return top;
        }

        return insertNode(top,head.next, element, pos, index + 1);
    }
}
