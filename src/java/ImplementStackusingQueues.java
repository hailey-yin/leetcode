package java;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by haileyyin on 5/2/18.
 */
public class ImplementStackusingQueues {
    Deque<Integer> queue;
    /** Initialize your data structure here. */
    public ImplementStackusingQueues() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.pollLast();
    }

    /** Get the top element. */
    public int top() {
        return queue.peekLast();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

class MyStack {
    Queue<Integer> queue_1;
    Queue<Integer> queue_2;
    public MyStack() {
        queue_1 = new LinkedList<>();
        queue_2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue_1.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while(queue_1.size() != 1) {
            queue_2.offer(queue_1.poll());
        }
        int result = queue_1.poll();
        while(!queue_2.isEmpty()){
            queue_1.offer(queue_2.poll());
        }
        return result;
    }

    /** Get the top element. */
    public int top() {
        while(queue_1.size() != 1) {
            queue_2.offer(queue_1.poll());
        }
        int result = queue_1.peek();
        queue_2.offer(queue_1.poll());
        while(!queue_2.isEmpty()){
            queue_1.offer(queue_2.poll());
        }
        return result;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue_1.isEmpty();
    }
}
