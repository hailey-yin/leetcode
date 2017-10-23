package java;

import java.util.Stack;

/**
 * Created by haileyyin on 10/22/17.
 */
public class AddTwoNumbers2 {
    /*
    在add two numbers 的基础上使用栈。
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode pre = null;
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while(l1!=null){
            s1.push(l1.val);
            l1 = (l1.next!=null)? l1.next:null;
        }
        while(l2!=null){
            s2.push(l2.val);
            l2 = (l2.next!=null)? l2.next:null;
        }

        while(!s1.isEmpty() || !s2.isEmpty() || carry==1){
            int value1 = (!s1.isEmpty())? s1.pop():0;
            int value2 = (!s2.isEmpty())? s2.pop():0;
            int sum = value1+ value2+carry;
            int value = sum%10;
            carry = sum/10;
            ListNode newNode = new ListNode(value);
            newNode.next = pre;
            pre = newNode;
        }
        return pre;
    }
}
