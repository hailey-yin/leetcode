package java;

/**
 * Created by haileyyin on 10/22/17.
 */
public class AddTwoNumbers {
    /*
    从个位往高位加，三种情况：
    value1+value2+carry
    Value1/value2 + carry
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while(l1!=null || l2!=null || carry==1) {
            int value1 = (l1!=null)? l1.val:0;
            int value2 = (l2!=null)? l2.val:0;
            int sum = value1+ value2+carry;
            int value = sum%10;
            carry = sum/10;
            l1 = (l1!=null)?((l1.next!=null)? l1.next:null):null;
            l2 = (l2!=null)?((l2.next!=null)? l2.next:null):null;
            cur.next = new ListNode(value);
            cur = cur.next;
        }
        return res.next;
    }
}
