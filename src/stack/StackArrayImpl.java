package stack;

public class StackArrayImpl<T> {
    private Object[] data;
    private int top = -1;

    public StackArrayImpl() {
        this.data = new Object[10];
    }

    public StackArrayImpl(int capacity) {
        this.data = new Object[capacity];
    }

    void push(T element) {
        if (top + 1 == data.length) {
            growDataArray();
        }
        data[++top] = element;
    }

    private void growDataArray() {
        Object[] temp = data;
        data = new Object[data.length * 2];
        System.arraycopy(temp, 0, data, 0, temp.length);
    }

    T pop() {
        if (size() == 0) {
            throw new RuntimeException("Stack is Empty");
        }
        return (T) data[top--];
    }

    T top() {
        if (size() == 0) {
            throw new RuntimeException("Stack is Empty");
        }
        return (T) data[top];
    }

    int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
