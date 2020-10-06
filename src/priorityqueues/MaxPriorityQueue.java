package priorityqueues;

import java.util.ArrayList;

public class MaxPriorityQueue {

    private final ArrayList<Integer> heap;

    public MaxPriorityQueue() {
        heap = new ArrayList<>();
    }

    public void insert(int element) {
        heap.add(element);
        upHeapify();
    }

    private void upHeapify() {
        int childIndex = getSize() - 1;
        int parentIndex = (childIndex - 1) / 2;
        while (parentIndex >= 0 && heap.get(parentIndex) < heap.get(childIndex)) {
            int temp = heap.get(parentIndex);
            heap.set(parentIndex, heap.get(childIndex));
            heap.set(childIndex, temp);
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
    }

    public int getMax() {
        if (getSize() == 0)
            throw new NullPointerException("PQ is Empty");
        return heap.get(0);
    }

    public int removeMax() {
        int temp = heap.get(0);
        heap.set(0, heap.get(getSize() - 1));
        heap.remove(getSize() - 1);
        downHeapify();
        return temp;
    }

    private void downHeapify() {
        int parentIndex = 0;
        int leftIndex = 1;
        int rightIndex = 2;
        int maxIndex;
        while (leftIndex < getSize()) {
            maxIndex = parentIndex;
            if (heap.get(maxIndex) < heap.get(leftIndex)) {
                maxIndex = leftIndex;
            }
            if (rightIndex<getSize()&&heap.get(maxIndex) < heap.get(rightIndex)) {
                maxIndex = rightIndex;
            }
            if (maxIndex == parentIndex)
                break;
            int temp = heap.get(parentIndex);
            heap.set(parentIndex, heap.get(maxIndex));
            heap.set(maxIndex, temp);
            parentIndex = maxIndex;
            leftIndex = 2 * parentIndex + 1;
            rightIndex = 2 * parentIndex + 2;
        }
    }

    public int getSize() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
