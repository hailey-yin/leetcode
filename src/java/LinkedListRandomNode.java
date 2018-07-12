package java;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by haileyyin on 7/6/18.
 */
public class LinkedListRandomNode {
    List<Integer> list;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode(ListNode head) {
        list = new LinkedList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
    }

    /** Returns a random node's value. */
    public int getRandom() {
        Random rand = new Random();
        int index = rand.nextInt(list.size());  //This will give value from 0 to list.size()-1
        return list.get(index);
    }
}
