package linkedlists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppendLastNToFirst {

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

            int n = Integer.parseInt(br.readLine().trim());
            head = appendLastNToFirst(head, n);
            print(head);

            t -= 1;
        }

    }

    private static LinkedListNode<Integer> appendLastNToFirst(LinkedListNode<Integer> head, int n) {
        if(head==null||n==0){
            return head;
        }

        LinkedListNode<Integer> current = head;
        for (int i = 0; i < n; i++) {
            current = current.next;
        }
        if(current==null){
            return head;
        }
        LinkedListNode<Integer> lastNNode = head;
        while (current.next != null) {
            lastNNode = lastNNode.next;
            current = current.next;
        }
        LinkedListNode<Integer> newHead = lastNNode.next;
        lastNNode.next = null;
        current.next = head;
        return newHead;
    }
}
