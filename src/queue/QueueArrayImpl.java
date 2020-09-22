package queue;

public class QueueArrayImpl {
    private int[] data = new int[10];
    private int front = -1;
    private int rear = -1;

    public void enqueue(int element) {
        if (size() == data.length)
            growSize();
        rear = (++rear % data.length);
        data[rear] = element;
    }

    private void growSize() {
        int[] temp = data;
        data = new int[data.length * 2];
        for (int i = 0; i < temp.length; i++) {
            data[i] = temp[(i + front+1) % temp.length];
        }
    }

    public int dequeue() {
        if (size() == 0)
            throw new RuntimeException("Queue is Empty");
        front = (++front % data.length);
        int element=data[front];
        if (size() == 0) {
            front = -1;
            rear = -1;
        }
        return element;
    }

    public int size() {
        return rear - front;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int front() {
        if (size() == 0)
            throw new RuntimeException("Queue is Empty");
        return data[front + 1];
    }
}
