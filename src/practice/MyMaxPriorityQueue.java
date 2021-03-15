package practice;

import java.util.ArrayList;
import java.util.Arrays;

public class MyMaxPriorityQueue {

    private static ArrayList<Integer> root = new ArrayList<>();

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 7, 3, 11, 8};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            upHeapify(arr, i);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            downHeapify(arr, i);
        }
    }

    private static void downHeapify(int[] arr, int end) {
        int temp = arr[0];
        arr[0] = arr[end];
        int parent = 0;
        int left = 2 * parent + 1;
        int right = 2 * parent + 2;
        int maxIndex;
        while (true) {
            maxIndex = parent;
            if (left < end && arr[left] > arr[maxIndex]) {
                maxIndex = left;
            }
            if (right < end && arr[right] > arr[maxIndex]) {
                maxIndex = right;
            }
            if (maxIndex == parent)
                break;
            int temp2 = arr[maxIndex];
            arr[maxIndex] = arr[parent];
            arr[parent] = temp2;
            parent = maxIndex;
            left = 2 * parent + 1;
            right = 2 * parent + 2;
        }
        arr[end] = temp;
    }

    private static void upHeapify(int[] arr, int end) {
        int child = end;
        int parent = (child - 1) / 2;
        while (child > 0 && arr[child] > arr[parent]) {
            int temp = arr[child];
            arr[child] = arr[parent];
            arr[parent] = temp;
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    private static int removeMax() {
        int temp = root.get(0);
        root.set(0, root.get(root.size() - 1));
        root.set(root.size() - 1, temp);
        root.remove(root.size() - 1);
        downHeapify();
        return temp;
    }

    private static void downHeapify() {
        int parent = 0;
        int left = (2 * parent) + 1;
        int right = (2 * parent) + 2;
        int maxIndex = 0;
        while (parent >= 0) {
            maxIndex = parent;
            if (left < root.size() && root.get(left) > root.get(parent)) {
                maxIndex = left;
            }
            if (right < root.size() && root.get(right) > root.get(maxIndex)) {
                maxIndex = right;
            }
            if (parent == maxIndex)
                break;
            int temp = root.get(parent);
            root.set(parent, root.get(maxIndex));
            root.set(maxIndex, temp);
            parent = maxIndex;
            left = (2 * parent) + 1;
            right = (2 * parent) + 2;
        }
    }

    private static void insert(int element) {
        root.add(element);
        upHeapify();
    }

    private static void upHeapify() {
        int child = root.size() - 1;
        int parent = ((child - 1) / 2);
        while (child > 0 && parent >= 0 && root.get(child) > root.get(parent)) {
            int temp = root.get(child);
            root.set(child, root.get(parent));
            root.set(parent, temp);
            child = parent;
            parent = ((child - 1) / 2);
        }
    }

}
