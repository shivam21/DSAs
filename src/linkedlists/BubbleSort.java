package linkedlists;

public class BubbleSort {

    public static void main(String[] args) {
        printList(bubbleSort(new LinkedListNode<>(4, new LinkedListNode<>(2, new LinkedListNode<>(3, new LinkedListNode<>(1))))));
    }

    public static LinkedListNode<Integer> bubbleSort(LinkedListNode<Integer> head) {
        if (head == null || head.next == null)
            return head;
        for(int i=0;i<len(head);i++){
            LinkedListNode<Integer> current = head;
            LinkedListNode<Integer> prev = null;
            while (current.next != null) {
                if (current.data > current.next.data) {
                    LinkedListNode<Integer> next = current.next.next;
                    if (prev != null) {
                        prev.next = current.next;
                        prev = prev.next;
                    } else {
                        head = current.next;
                        prev = head;
                    }
                    current.next.next = current;
                    current.next = next;
                } else {
                    prev = current;
                    current = current.next;
                }
            }
        }
        return head;
    }

    private static int len(LinkedListNode<Integer> head){
        int len=0;
        while(head!=null){
            len++;
            head=head.next;
        }
        return len;
    }

    private static void printList(LinkedListNode<Integer> temp) {
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
