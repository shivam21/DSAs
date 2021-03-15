package priorityqueues;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*You want to buy a ticket for a well-known concert which is happening in your city. But the number of tickets available is limited. Hence the sponsors of the concert decided to sell tickets to customers based on some priority.
        A queue is maintained for buying the tickets and every person has attached with a priority (an integer, 1 being the lowest priority). The tickets are sold in the following manner -
        1. The first person (pi) in the queue asked to comes out.
        2. If there is another person present in the queue who has higher priority than pi, then ask pi to move at end of the queue without giving him the ticket.
        3. Otherwise, give him the ticket (and don't make him stand in queue again).
        Giving a ticket to a person takes exactly 1 minutes and it takes no time for removing and adding a person to the queue. And you can assume that no new person joins the queue.
        Given a list of priorities of N persons standing in the queue and the index of your priority (indexing starts from 0). Find and return the time it will take until you get the ticket.*/

public class BuyTicket {

    public static int buyTicket(int input[], int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> queue = new LinkedList<>();
        for (int element : input)
            maxHeap.add(element);
        for (int i = 0; i < input.length; i++) queue.add(i);
        int time = 0;
        while (true) {
            if (input[queue.peek()]==(maxHeap.peek())) {
                time++;
                if (queue.poll() == k) {
                    break;
                }
                maxHeap.poll();
            } else {
                queue.add(queue.poll());
            }
        }
        return time;
    }

}
