package linkedlists;

public class SwapNodes {

    public static  LinkedListNode<Integer> swap_nodes(LinkedListNode<Integer> head,int i,int j){
        LinkedListNode<Integer> current=head;
        LinkedListNode<Integer> prev=null;
        int p=0;
        while(current!=null&&p++<i){
            prev=current;
            current=current.next;
        }
        LinkedListNode<Integer> prev2=null;
        LinkedListNode<Integer> current2=head;
        int q=0;
        while(current2!=null&&q++<j){
            prev2=current2;
            current2=current2.next;
        }
        if(prev!=null)
            prev.next=current2;
        else
            head=current2;
        LinkedListNode<Integer> next=current2.next;
        if(prev2==current){
            current2.next=current;
        }else{
            if (current != null) {
                current2.next=current.next;
            }
            if (prev2 != null) {
                prev2.next=current;
            }
        }
        current.next=next;
        return head;
    }
}
