package java;

/**
 * Created by haileyyin on 10/22/17.
 */
public class LinkedListCycle {
    /*
    1. Use two pointers, walker and runner.
    2. walker moves step by step. runner moves two steps at time.
    3. if the Linked List has a cycle walker and runner will meet at some point.
     */
    public boolean hasCycle(ListNode head) {
        if(head==null)
            return false;
        ListNode walker = head;
        ListNode runner = head;
        while(runner.next!=null && runner.next.next!=null){
            walker = walker.next;
            runner = runner.next.next;
            if(runner == walker) return true;
        }
        return false;
    }
}
