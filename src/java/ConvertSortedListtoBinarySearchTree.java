package java;

/**
 * Created by haileyyin on 1/15/18.
 */
public class ConvertSortedListtoBinarySearchTree {
    /*
    iterate through the linked list to get the number of node, and get the center by iterate from the head again.
     */
    public TreeNode sortedListToBST(ListNode head) {
        ListNode pointer = head;
        int n=0;
        while(pointer!=null){
            pointer = pointer.next;
            n++;
        }
        if(n==1)
            return new TreeNode(head.val);
        if(n==0)
            return null;
        pointer = head;
        int center = n/2;;
        while(center>1){
            pointer = pointer.next;
            center--;
        }
        TreeNode root = new TreeNode(pointer.next.val);
        ListNode rightHead = pointer.next.next;
        pointer.next = null;
        TreeNode left = sortedListToBST(head);
        root.left = left;
        if(rightHead!=null){
            TreeNode right = sortedListToBST(rightHead);
            root.right = right;
        }
        return root;
    }
    /*
    update: using two pointers slow and fast to get the center.
     */
    public TreeNode sortedListToBST2(ListNode head) {
        if(head==null)
            return null;
        return sortedListToBST(head, null);
    }

    private  TreeNode sortedListToBST(ListNode head, ListNode tail){
        if(head==tail)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=tail && fast.next!=tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head, slow);
        root.right = sortedListToBST(slow.next, tail);
        return root;
    }

}
