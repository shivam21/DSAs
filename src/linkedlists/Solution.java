package linkedlists;

public class Solution {

    public static LinkedListNode<Integer> reverse_R(LinkedListNode<Integer> head) {
        return reverse_R_Double(head).head;
    }

    public static DoubleNode<Integer> reverse_R_Double(LinkedListNode<Integer> head) {
        if (head == null || head.next == null)
            return new DoubleNode<Integer>(head, head);
        DoubleNode<Integer> newPair = reverse_R_Double(head.next);
        LinkedListNode<Integer> outputHead = newPair.head;
        LinkedListNode<Integer> outputTail = newPair.tail;
        head.next = null;
        outputTail.next = head;
        return new DoubleNode<Integer>(outputHead, head);
    }

    public static DoubleNode<Integer> reverse_R_Double2(LinkedListNode<Integer> head) {
        if (head == null || head.next == null)
            return new DoubleNode<Integer>(head, head);
        DoubleNode<Integer> newPair = reverse_R_Double(head.next);
        newPair.tail.next = head;
        newPair.tail=newPair.tail.next;
        newPair.tail.next=null;


        return newPair;
    }
}

