package linkedlists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
You have been given a singly linked list of integers along with two integers, 'M,' and 'N.' Traverse the linked list such that you retain the 'M' nodes, then delete the next 'N' nodes. Continue the same until the end of the linked list.
        To put it in other words, in the given linked list, you need to delete N nodes after every M nodes.
*/

public class SkipMdeleteN {
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

            LinkedListNode<Integer> head = takeInput();
            String[] m_n = br.readLine().trim().split("\\s");

            int m = Integer.parseInt(m_n[0]);
            int n = Integer.parseInt(m_n[1]);

            LinkedListNode<Integer> newHead = skipMdeleteN(head, m, n);
            print(newHead);

            t -= 1;
        }

    }

    public static LinkedListNode<Integer> skipMdeleteN(LinkedListNode<Integer> head, int M, int N) {
        if (head == null)
            return null;
        LinkedListNode<Integer> current = head;
        for (int i = 0; i < M - 1; i++) {
            if (current == null)
                break;
            current = current.next;
        }
        LinkedListNode<Integer> current2 = current;
        for (int i = 0; i < N; i++) {
            if (current2 == null)
                break;
            current2 = current2.next;
        }
        if (current != null && current2 == null) {
            current.next = null;
        }
        if (current != null && current2 != null)
            current.next = skipMdeleteN(current2.next, M, N);
        return head;
    }
}
