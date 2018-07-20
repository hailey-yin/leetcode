package java;

import java.util.Stack;

/**
 * Created by haileyyin on 7/17/18.
 */
public class VeriPreorderSequenceinBinarySearchTree {
    /*
    dfs, iterative
     */

    /*
     keeping a stack of nodes, use the popped values as a lower bound
     */
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        Stack<Integer> path = new Stack();
        for (int p : preorder) {
            if (p < low)
                return false;
            while (!path.empty() && p > path.peek())
                low = path.pop();
            path.push(p);
        }
        return true;
    }
    /*
    recursive
    A BST's left child is always < root and right child is always > root.
     */
    public boolean verifyPreorder2(int[] preorder) {
        if(preorder == null || preorder.length == 0) return true;
        return verify(preorder, 0, preorder.length - 1);
    }

    private boolean verify(int[] a, int start, int end) {
        if(start >= end) return true;
        int pivot = a[start];
        int bigger = -1;
        for(int i = start + 1; i <= end; i++) {
            if(bigger == -1 && a[i] > pivot) bigger = i;
            if(bigger != -1 && a[i] < pivot) return false;
        }
        if(bigger == -1) {
            return verify(a, start + 1, end);
        } else {
            return verify(a, start + 1, bigger - 1) && verify(a, bigger, end);
        }
    }

}
