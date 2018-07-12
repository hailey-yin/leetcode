package java;

/**
 * Created by haileyyin on 6/23/18.
 */
public class PlusOneLinkedList {
    /*
    most cleaver method:
    find the last non-9 digit, plus one and set all digit behind it to 0
     */
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode i = dummy;
        ListNode j = dummy;

        while (j.next != null) {
            j = j.next;
            if (j.val != 9) {
                i = j;
            }
        }

        if (j.val != 9) {
            j.val++;
        } else {
            i.val++;
            i = i.next;
            while (i != null) {
                i.val = 0;
                i = i.next;
            }
        }

        if (dummy.val == 0) {
            return dummy.next;
        }

        return dummy;
    }
    /*
    We can reverse the list so that the addition would be less time-consuming
    Time: O(n)
    space: O(1)
     */
    public ListNode plusOne1(ListNode head) {
        ListNode h2 = reverse(head);

        ListNode p=h2;

        while(p!=null){
            if(p.val+1<=9){
                p.val=p.val+1;
                break;
            }else{
                p.val=0;
                if(p.next==null){
                    p.next = new ListNode(1);
                    break;
                }
                p=p.next;
            }
        }

        return reverse(h2);
    }

    public ListNode reverse(ListNode head){
        if(head==null||head.next==null)
            return head;
        ListNode p1=head;
        ListNode p2=p1.next;
        while(p2!=null){
            ListNode t = p2.next;
            p2.next=p1;
            p1=p2;
            p2=t;
        }
        head.next=null;
        return p1;
    }
    /*
    So basically the problem is to imitate addition process.
    The standard algorithm for adding numbers is to align the addends vertically and add the columns, starting from the ones columns on the right. If a column exceeds 9, the extra digit is carried into the next column.
    primitive way
    time: O(n^2)
    space: O(1)
    */
    public ListNode plusOne2(ListNode head) {
        int m = 1;                     // to keep track of the integer position we are working on.
        ListNode cur = head;           //pointer to the current node that we are visiting
        while(cur.next != null) {      // trying to find the right most position of the integer
            m++;
            cur = cur.next;
        }
        cur.val++;                     // plus one
        while (cur.val == 10 && m > 1) {        // carry the extra digit to the previous node
            cur.val = 0;
            m--;
            int n = 1;
            cur = head;
            while (n < m) {
                cur = cur.next;
                n++;
            }
            cur.val++;
        }
        if (cur.val == 10) {                     // deal with the overflow
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            head.val = 0;
            return newHead;
        }
        return head;
    }
}
