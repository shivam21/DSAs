package queue;

import linkedlists.LinkedListNode;

public class QueueLLImpl<T> {
    private LinkedListNode<T> head;
    private LinkedListNode<T> rear;
    private int size = 0;

    public void enqueue(T element) {
        if (rear == null) {
            rear = new LinkedListNode<>(element);
            head = rear;
        } else {
            rear.next = new LinkedListNode<>(element);
            rear = rear.next;
        }
        size++;
    }


    public T dequeue() {
        if (size() == 0)
            throw new RuntimeException("Queue is Empty");
        T element = head.data;
        head = head.next;
        size--;
        if (size == 0) {
            head = null;
            rear = null;
        }
        return element;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T front() {
        if (size() == 0)
            throw new RuntimeException("Queue is Empty");
        return head.data;
    }
}
