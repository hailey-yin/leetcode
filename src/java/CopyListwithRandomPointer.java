package java;

/**
 * Created by haileyyin on 1/15/18.
 */
public class CopyListwithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        //copy each node and place each copy right after its original, before its next
        RandomListNode pointer1 = head;
        while(pointer1!=null){
            RandomListNode copy = new RandomListNode(pointer1.label);
            copy.next = pointer1.next;
            pointer1.next = copy;
            pointer1 = copy.next;
        }
        //create random pointer for each copy node
        pointer1 = head;
        while(pointer1!=null){
            if(pointer1.random!=null)
                pointer1.next.random = pointer1.random.next;
            pointer1 = pointer1.next.next;
        }
        //extract copy nodes
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode pointer2 = dummy;
        pointer1 = head;
        while(pointer1!=null){
            pointer2.next = pointer1.next;
            pointer1.next = pointer1.next.next;
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        return dummy.next;
    }
}
