package stack;

import linkedlists.LinkedListNode;

public class StackLLImpl<T> {
    private LinkedListNode<T> head;
    private int size = 0;

    void push(T element) {
        LinkedListNode<T> newNode = new LinkedListNode<>(element);
        newNode.next = head;
        head = newNode;
        size++;
    }

    T pop() {
        if (size() == 0) {
            throw new RuntimeException("Stack is Empty");
        }
        LinkedListNode<T> next = head.next;
        T element = head.data;
        head.next = null;
        head = next;
        size--;
        return element;
    }

    T top() {
        if (size() == 0) {
            throw new RuntimeException("Stack is Empty");
        }
        return head.data;
    }

    int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
