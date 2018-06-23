package java;

/**
 * Created by haileyyin on 5/2/18.
 */
public class DeleteNodeinaLinkedList {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
