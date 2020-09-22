package test;

import java.util.ArrayList;

public class Dequeue {
    private final ArrayList<Integer> list = new ArrayList<Integer>(10);

    public Dequeue(int i) {
        list.add(i);
    }

    public void insertFront(int input) {
        if (list.size() == 10) {
            System.out.println("-1");
            return;
        }
        list.add(0, input);
    }

    public void insertRear(int input) {
        if (list.size() == 10) {
            System.out.println("-1");
            return;
        }
        list.add(input);
    }

    public void deleteFront() {
        if (list.isEmpty()) {
            System.out.println("-1");
            return;
        }
        list.remove(0);
    }

    public void deleteRear() {
        if (list.isEmpty()) {
            System.out.println("-1");
            return;
        }
        list.remove(list.size() - 1);
    }

    public int getFront() {
        if (list.isEmpty()){
            return -1;
        }
        return list.get(0);
    }

    public int getRear() {
        if (list.isEmpty()){
            return -1;
        }
        return list.get(list.size() - 1);
    }
}
