package java;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by haileyyin on 10/22/17.
 */
public class MergekSortedLists {
    /*
    The simplest solution is using PriorityQueue. The elements of the priority queue are ordered according to their natural ordering, or by a comparator provided at the construction time (in this case).
    Time: log(k) * n.
    k is number of list and n is number of total elements.
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        ListNode head = new ListNode(0);
        ListNode pointer = head;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        //put the first elements in every list into queue
        for(ListNode list:lists){
            if(list!=null)
                queue.offer(list);
        }
        //poll out the smallest one, and insert new;
        while(!queue.isEmpty()){
            ListNode temp = queue.poll();
            pointer.next = temp;
            pointer = pointer.next;
            if(temp.next!=null)
                queue.offer(temp.next);
        }
        return head.next;
    }
}
