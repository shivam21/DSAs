package linkedlists;

public class IsPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(new LinkedListNode<>(3, new LinkedListNode<>(9, new LinkedListNode<>(1, new LinkedListNode<>(2, new LinkedListNode<>(9, new LinkedListNode<>(3))))))));
    }

    public static boolean isPalindrome(LinkedListNode<Integer> head) {
        if (head == null || head.next == null)
            return true;
        LinkedListNode<Integer> mid = findMid(head);
        LinkedListNode<Integer> otherHalf = reverseList(mid.next);
        mid.next = null;
        while (otherHalf != null) {
            if (!head.data.equals(otherHalf.data))
                return false;
            otherHalf = otherHalf.next;
            head = head.next;
        }
        return true;
    }


    private static LinkedListNode<Integer> reverseList(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> current = head;
        while (current != null) {
            LinkedListNode<Integer> next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    private static LinkedListNode<Integer> findMid(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head;
        while (fast!=null&&fast.next != null&&fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
