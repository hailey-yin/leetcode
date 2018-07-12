package java;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by haileyyin on 6/27/18.
 */
public class FindMedianfromDataStream {
/*
    keep two heaps. one MAX-heap and one MIN-heap.
    Max-heap small has the smaller half of the numbers.
    Min-heap large has the larger half of the numbers.
    Suppose there are n numbers so far.
    if n is odd, size of MAX-heap is (n/2)+1, size of MIN-heap is (n/2), the median is the top of MAX-heap
    if n is even, size of MAX-heap equals to size of MIN-heap, which is (n/2),
                  the median is the average between the top of MAX-heap and the top of MIN-heap

    */

    Queue<Long> min;
    Queue<Long> max;

    /** initialize your data structure here. */
    public FindMedianfromDataStream() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>();
    }

    public void addNum(int num) {
        max.add((long)num);
        min.add(-max.poll());
        if (min.size() > max.size()) {
            max.add(-min.poll());
        }
    }

    public double findMedian() {
        if (min.size() < max.size()) {
            return max.peek();
        } else {
            return (double)(max.peek() - min.peek()) / 2;
        }
    }
}
