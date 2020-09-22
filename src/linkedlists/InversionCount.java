package linkedlists;

class ListNode<t> {
    public t data;
    public ListNode<t> next;

    public ListNode(t data) {
        this.data = data;
    }

    public ListNode(t i, ListNode<t> tListNode) {
        this.data = i;
        this.next = tListNode;
    }
}

class HeadCount<t> {
    int count;
    ListNode<t> head;

    public HeadCount(int count, ListNode<t> head) {
        this.count = count;
        this.head = head;
    }
}

public class InversionCount {

    public static void main(String[] args) {
        System.out.println(InversionCount(new ListNode<>(3, new ListNode<>(2, new ListNode<>(1, new ListNode<>(5, new ListNode<>(4)))))));
    }

    public static int InversionCount(ListNode<Integer> head) {
        return findInversionCount(head).count;
    }

    private static HeadCount<Integer> findInversionCount(ListNode<Integer> head) {
        if (head == null || head.next == null)
            return new HeadCount<>(0, head);
        ListNode<Integer> mid = findMid(head);
        HeadCount<Integer> headCount1 = findInversionCount(head);
        HeadCount<Integer> headCount2 = findInversionCount(mid);
        HeadCount<Integer> result = merge(headCount1.head, headCount2.head);
        result.count = result.count + headCount1.count + headCount2.count;
        return result;
    }

    private static HeadCount<Integer> merge(ListNode<Integer> head1, ListNode<Integer> head2) {
        ListNode<Integer> head = null;
        ListNode<Integer> headTop = null;
        int count = 0;
        while (head1 != null & head2 != null) {
            if (head1.data <= head2.data) {
                if (head == null) {
                    head = head1;
                    headTop = head1;
                } else {
                    head.next = head1;
                    head = head.next;
                }
                head1 = head1.next;
            } else {
                count += len(head1);
                if (head == null) {
                    head = head2;
                    headTop = head2;
                } else {
                    head.next = head2;
                    head = head.next;
                }
                head2 = head2.next;
            }
        }
        if (head1 == null && head2 != null) {
            if (head != null) {
                head.next = head2;
            } else {
                return new HeadCount<>(count, head2);
            }
        }
        if (head1 != null) {
            if (head != null) {
                head.next = head1;
            } else {
                return new HeadCount<>(count, head1);
            }
        }
        return new HeadCount<>(count, headTop);
    }

    private static int len(ListNode<Integer> head1) {
        int size = 0;
        while (head1 != null) {
            size++;
            head1 = head1.next;
        }
        return size;
    }

    private static ListNode<Integer> findMid(ListNode<Integer> head) {
        ListNode<Integer> slow = head;
        ListNode<Integer> fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode<Integer> next = null;
        if (slow != null) {
            next = slow.next;
            slow.next = null;
        }
        return next;
    }
}
