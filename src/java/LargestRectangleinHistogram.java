package java;

import java.util.Stack;

/**
 * Created by haileyyin on 10/22/17.
 */
public class LargestRectangleinHistogram {
    /*
    方法一：如果height递增，不计算，是为了找到右边界
    curIdx,minHeight(有效范围：每次找到一个驼峰curIdx，往回遍历时),maxArea
     */
    public int largestRectangleArea1(int[] heights) {
        //O(n^2)
        if (heights == null || heights.length == 0)
            return 0;
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            if (i == heights.length - 1 || heights[i] > heights[i + 1]) {
                int minHeight = heights[i];
                for (int j = i; j >= 0; j--) {
                    minHeight = Math.min(minHeight, heights[j]);
                    max = Math.max(max, minHeight * (i - j + 1));
                }
            }
        }
        return max;
    }
    /*
    方法二：栈
     */
    public int largestRectangleArea2(int[] heights) {
        //O(n)
        if(heights ==null || heights.length ==0)
            return 0;
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<heights.length; i++){
            if(stack.isEmpty() || heights[i]>heights[stack.peek()]){
                stack.push(i);
            } else {
                int right = i;
                int index = stack.pop();
                while(!stack.isEmpty() && heights[index]==heights[stack.peek()]){
                    index=stack.pop();
                }
                int leftMost = (stack.isEmpty())?-1:stack.peek();
                max=Math.max(max,(right-leftMost-1)*heights[index]);
                i--;
            }
        }
        int rightMost = stack.peek()+1;
        while(!stack.isEmpty()){
            int index=stack.pop();
            int left=(stack.isEmpty())?-1:stack.peek();
            max=Math.max(max,(rightMost-left-1)*heights[index]);
        }
        return max;
    }
}
