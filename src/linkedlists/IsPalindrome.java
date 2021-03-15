package linkedlists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
You have been given a head to a singly linked list of integers. Write a function check to whether the list given is a 'Palindrome' or not.
*/
public class IsPalindrome {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static LinkedListNode<Integer> takeInput() throws IOException {
        LinkedListNode<Integer> head = null, tail = null;

        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        while(i < datas.length && !datas[i].equals("-1")) {
            int data = Integer.parseInt(datas[i]);
            LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
            if(head == null) {
                head = newNode;
                tail = newNode;
            }
            else {
                tail.next = newNode;
                tail = newNode;
            }
            i += 1;
        }

        return head;
    }

    public static void print(LinkedListNode<Integer> head){
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        int t = Integer.parseInt(br.readLine().trim());

        while (t > 0) {

            LinkedListNode<Integer> head = takeInput();

            boolean ans = isPalindrome(head);
            System.out.println(ans);

            t -= 1;

        }

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
