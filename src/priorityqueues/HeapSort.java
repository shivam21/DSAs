package priorityqueues;

public class HeapSort {


    void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            upHeapify(arr, i);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            downHeapify(arr, i);
        }
    }

    private void downHeapify(int[] arr, int end) {
        int temp = arr[0];
        arr[0] = arr[end];
        int index = 0;
        int leftChild = 1;
        int rightChild = 2;
        while (leftChild < end) {
            int minIndex = index;
            if (arr[leftChild] < arr[minIndex])
                minIndex = leftChild;
            if (rightChild < end && arr[rightChild] < arr[minIndex])
                minIndex = rightChild;
            if (minIndex == index)
                break;
            int temp2 = arr[minIndex];
            arr[minIndex] = arr[index];
            arr[index] = temp2;
            index = minIndex;
            leftChild = 2 * index + 1;
            rightChild = 2 * index + 2;
        }
        arr[end] = temp;
    }

    private void upHeapify(int[] arr, int end) {
        int childIndex = end;
        int parentIndex = (childIndex - 1) / 2;
        while (parentIndex >= 0 && arr[childIndex] < arr[parentIndex]) {
            int temp = arr[childIndex];
            arr[childIndex] = arr[parentIndex];
            arr[parentIndex] = temp;
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
    }
}
