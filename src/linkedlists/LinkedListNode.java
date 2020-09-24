package linkedlists;

public class LinkedListNode<T> {
    public T data;
    public LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
    }

    public LinkedListNode(T data, LinkedListNode<T> tLinkedListNode) {
        this.data = data;
        this.next = tLinkedListNode;
    }


}
