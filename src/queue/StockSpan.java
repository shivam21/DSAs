package queue;

import java.util.LinkedList;
import java.util.Queue;

public class StockSpan {
    public static int[] stockSpan(int[] price) {
        // Write your code here
        Queue<Integer> q=new LinkedList<>();
        int[] result=new int[price.length];
        int k=0;
        for(int val:price){
            while(!q.isEmpty()&&val<q.peek()){
                q.poll();
            }
            q.add(val);
            result[k++]=q.size();
        }
        return result;

    }
}
