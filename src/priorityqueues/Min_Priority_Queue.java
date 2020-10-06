package priorityqueues;

import java.util.ArrayList;

public class Min_Priority_Queue {
    private final ArrayList<Integer> heap;

    public Min_Priority_Queue() {
        this.heap = new ArrayList<>();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }

    public int getMin() {
        if (heap.isEmpty())
            throw new RuntimeException("Priority Queue is Empty");
        return heap.get(0);
    }

    public void insert(int data) {
        heap.add(data);
        upHeapify();
    }

    private void upHeapify() {
        int childIndex = size() - 1;
        int parentIndex = (childIndex - 1) / 2;
        while (childIndex > 0 && heap.get(childIndex) < heap.get(parentIndex)) {
            int temp = heap.get(childIndex);
            heap.set(childIndex, heap.get(parentIndex));
            heap.set(parentIndex, temp);
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
    }

    public int remove() {
        if (heap.isEmpty())
            throw new RuntimeException("Priority Queue is Empty");
        int min = heap.get(0);
        heap.set(0, heap.get(size() - 1));
        heap.remove(size() - 1);
        downHeapify(0);
        return min;
    }

    private void downHeapify(int rootIndex) {
        int leftChildIndex = 2 * rootIndex + 1;
        int rightChildIndex = 2 * rootIndex + 2;
        if (leftChildIndex >= size())
            return;
        int right = Integer.MAX_VALUE;
        if (rightChildIndex < size())
            right = heap.get(rightChildIndex);
        int minimum = Math.min(heap.get(rootIndex), Math.min(heap.get(leftChildIndex), right));
        if (heap.get(rootIndex) == minimum)
            return;
        int temp;
        if (heap.get(leftChildIndex) == minimum) {
            temp = heap.get(leftChildIndex);
            heap.set(leftChildIndex, heap.get(rootIndex));
        }else{
            temp = heap.get(rightChildIndex);
            heap.set(rightChildIndex, heap.get(rootIndex));
        }
        heap.set(rootIndex, temp);
        downHeapify(leftChildIndex);
        downHeapify(rightChildIndex);
    }


}
