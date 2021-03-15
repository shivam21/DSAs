package linkedlists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
You have been given two sorted(in ascending order) singly linked lists of integers.
        Write a function to merge them in such a way that the resulting singly linked list is also sorted(in ascending order) and return the new head to the list.
*/

public class MergeTwoSortedLL {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static LinkedListNode<Integer> takeInput() throws IOException {
        LinkedListNode<Integer> head = null, tail = null;

        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        while (i < datas.length && !datas[i].equals("-1")) {
            int data = Integer.parseInt(datas[i]);
            LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            i += 1;
        }

        return head;
    }

    public static void print(LinkedListNode<Integer> head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        int t = Integer.parseInt(br.readLine().trim());

        while (t > 0) {

            LinkedListNode<Integer> head1 = takeInput();
            LinkedListNode<Integer> head2 = takeInput();

            LinkedListNode<Integer> newHead = mergeTwoSortedLinkedLists(head1, head2);
            print(newHead);

            t -= 1;
        }

    }

    public static LinkedListNode<Integer> mergeTwoSortedLinkedLists(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
        LinkedListNode<Integer> newHead = null;
        LinkedListNode<Integer> headTop = null;
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                if (newHead == null) {
                    headTop=head1;
                    newHead = head1;
                } else {
                    newHead.next = head1;
                    newHead = newHead.next;
                }
                head1 = head1.next;
            } else {
                if (newHead == null) {
                    headTop=head2;
                    newHead = head2;
                } else {
                    newHead.next = head2;
                    newHead = newHead.next;
                }
                head2 = head2.next;
            }
        }
        if (head1 != null) {
            if (newHead != null) {
                newHead.next = head1;
            } else {
                headTop=head1;
                newHead = head1;
            }
        }
        if (head2 != null) {
            if (newHead != null) {
                newHead.next = head2;
            } else {
                headTop=head2;
                newHead = head2;
            }
        }
        return headTop;
    }
}
