package java;

/**
 * Created by haileyyin on 10/22/17.
 */
public class LinkedListCycle2 {
    /*
    - Step 1: Determine whether there is a cycle
    1. Use two pointers, walker and runner.
    2. walker moves step by step. runner moves two steps at time.
    3. if the Linked List has a cycle walker and runner will meet at some point.
    - Step 2: If there is a cycle, return the entry location of the cycle
    1. L1 is defined as the distance between the head point and entry point
    2. L2 is defined as the distance between the entry point and the meeting point
    3. C is defined as the length of the cycle
    4. n is defined as the travel times of the fast pointer around the cycle When the first encounter of the slow pointer and the fast pointer
    5. we can obtain:
    -the total distance of the slow pointer traveled when encounter is L1 + L2
    -the total distance of the fast pointer traveled when encounter is L1 + L2 + n * C
    -Because the total distance the fast pointer traveled is twice as the slow pointer, Thus: 2 * (L1+L2) = L1 + L2 + n * C => L1 + L2 = n * C => L1 = (n - 1) C + (C - L2)*
    6. 所以L1=C-L2.
     */
    public ListNode detectCycle(ListNode head) {
        if(head==null)
            return null;
        ListNode walker = head;
        ListNode runner = head;
        ListNode entry = head;
        while(runner.next!=null && runner.next.next!=null){
            walker = walker.next;
            runner = runner.next.next;
            if(runner == walker){
                while(walker!=entry){
                    walker = walker.next;
                    entry = entry.next;
                }
                return entry;
            }
        }
        return null;
    }
}
