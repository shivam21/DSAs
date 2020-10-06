package priorityqueues;

import java.util.Arrays;
import java.util.Scanner;

public class Priority_Queue_Use {
    public static void main(String[] args) {
//        Min_Priority_Queue pq = new Min_Priority_Queue();
//        pq.insert(10);
//        pq.insert(4);
//        pq.insert(15);
//        pq.insert(2);
//        pq.insert(5);
//        System.out.println(pq.getMin());
//        System.out.println(pq.remove());
//        System.out.println(pq.remove());
//        System.out.println(pq.getMin());
//        System.out.println(pq.remove());
//        System.out.println(pq.remove());
//        System.out.println(pq.remove());

//        Scanner s = new Scanner(System.in);
//        MaxPriorityQueue pq = new MaxPriorityQueue();
//        int choice = s.nextInt();
//        while(choice != -1) {
//            switch(choice) {
//                case 1 : // insert
//                    int element = s.nextInt();
//                    pq.insert(element);
//                    break;
//                case 2 : // getMax
//                    System.out.println(pq.getMax());
//                    break;
//                case 3 : // removeMax
//                    System.out.println(pq.removeMax());
//                    break;
//                case 4 : // size
//                    System.out.println(pq.getSize());
//                    break;
//                case 5 : // isEmpty
//                    System.out.println(pq.isEmpty());
//                default :
//                    return;
//            }
//            choice = s.nextInt();
//        }
        int[] arr = {3, 5, 2, 7, 4, 1};
        new HeapSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
