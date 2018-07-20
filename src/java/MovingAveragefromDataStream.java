package java;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by haileyyin on 7/19/18.
 */
public class MovingAveragefromDataStream {
    int sum = 0;
    Queue<Integer> queue = new LinkedList<>();
    int maxsize = 0;

    /** Initialize your data structure here. */
    public MovingAveragefromDataStream(int size) {
        maxsize = size;
    }

    public double next(int val) {
        queue.offer(val);
        sum += val;
        if (queue.size() > maxsize) {
            sum -= queue.remove();
        }
        return (double)sum/queue.size();
    }
}
