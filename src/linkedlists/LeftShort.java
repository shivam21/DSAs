package linkedlists;

import java.util.*;

public class LeftShort {

    public static void main(String[] args) {
        ListNode<Integer> tail = new ListNode<>(5);
        ListNode<Integer> next = new ListNode<>(3, new ListNode<>(4, tail));
        ListNode<Integer> head = new ListNode<>(2, next);
        tail.next = next;
        NewLoop(head);
        printList(head);
    }

    private static void printList(ListNode<Integer> temp) {
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static ListNode<Integer> NewLoop(ListNode<Integer> head) {
        if (head == null || head.next == null)
            return head;
        TreeMap<Integer, ListNode<Integer>> map = new TreeMap<Integer, ListNode<Integer>>();
        ListNode<Integer> current = head;
        while (current != null && current.next != null) {
            if (map.containsKey(current.next.data)) {
                int data = current.next.data;
                boolean isFound = false;
                for (int i : map.keySet()) {
                    if (i > data) {
                        isFound = true;
                        current.next = map.get(i);
                        break;
                    }
                }
                if (!isFound) {
                    current.next = null;
                }
                break;
            }
            map.put(current.data, current);
            current = current.next;
        }
        return head;
    }

    private static ListNode<Integer> removeDuplicates(ListNode<Integer> head) {
        if (head == null || head.next == null)
            return head;
        ListNode<Integer> headTop = head;
        ListNode<Integer> prev = null;
        Set<Integer> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head.data)) {
                prev.next = head.next;
            } else {
                set.add(head.data);
                prev = head;
            }
            head = head.next;
        }
        return headTop;
    }

    private static ListNode<Integer> reverseList(ListNode<Integer> head) {
        if (head == null || head.next == null)
            return head;
        ListNode<Integer> tail = head.next;
        ListNode<Integer> newHead = reverseList(head.next);
        tail.next = head;
        head.next = null;
        return newHead;
    }
}
