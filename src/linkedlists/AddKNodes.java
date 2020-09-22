package linkedlists;

public class AddKNodes {

    public static void main(String[] args) {
        ListNode<Integer> head = new ListNode<>(1);
        head = AddKNodes(head, 3);
        printList(head);
    }

    public static ListNode<Integer> AddKNodes(ListNode<Integer> head, int k) {
        ListNode<Integer> top = head;
        ListNode<Integer> prev = null;
        int sum = 0;
        int currentSize = 1;
        while (head != null) {
            sum += head.data;
            if (currentSize % k == 0) {
                ListNode<Integer> newNode = new ListNode<>(sum);
                newNode.next = head.next;
                head.next = newNode;
                sum = 0;
                prev = null;
                head = head.next.next;
            } else {
                prev = head;
                head = head.next;
            }
            currentSize++;
        }
        ListNode<Integer> newNode = new ListNode<>(sum);
        if (prev != null) {
            prev.next = newNode;
        }
        return top;
    }

    static void printList(ListNode<Integer> temp) {
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
