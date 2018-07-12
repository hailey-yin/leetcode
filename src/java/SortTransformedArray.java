package java;

/**
 * Created by haileyyin on 7/10/18.
 */
public class SortTransformedArray {
    /*
        the graph of quadratic function is a plane curve
        if a is positive, the curve opens upwards
        if a is negative, the curve opens downwards
        the location of the axis of symmetry is controled by x = -b/2a
        */
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] res = new int[nums.length];
        if (a == 0) {
            if (b > 0) { // in increasing order
                for (int i = 0; i < nums.length; i++) {
                    res[i] = getQuadraticValue(a, b, c, nums[i]);
                }
            } else { // in decreasing order
                for (int i = nums.length - 1; i >= 0; i--) {
                    res[nums.length - i - 1] = getQuadraticValue(a, b, c, nums[i]);
                }
            }
            return res;
        }
        double center = - (double)b / (2 * a);
        int mid = binarySearch(nums, center);
        if (mid >= 0 || mid + 1 < nums.length) {
            int lo = mid, hi = mid + 1;
            if (a < 0) { // the closer to center, the larger the value
                int idx = nums.length - 1;
                while (lo >= 0 && hi < nums.length) {
                    if (Math.abs(nums[hi] - center) < Math.abs(center - nums[lo])) {
                        res[idx--] = getQuadraticValue(a, b, c, nums[hi++]);
                    } else {
                        res[idx--] = getQuadraticValue(a, b, c, nums[lo--]);
                    }
                }
                if (lo >= 0){
                    while (lo >= 0) {
                        res[idx--] = getQuadraticValue(a, b, c, nums[lo--]);
                    }
                }
                if (hi < nums.length) {
                    while (hi < nums.length) {
                        res[idx--] = getQuadraticValue(a, b, c, nums[hi++]);
                    }
                }
            } else { // the closer to center, the smaller the value
                int idx = 0;
                while (lo >= 0 && hi < nums.length) {
                    if (Math.abs(nums[hi] - center) < Math.abs(center - nums[lo])) {
                        res[idx++] = getQuadraticValue(a, b, c, nums[hi++]);
                    } else {
                        res[idx++] = getQuadraticValue(a, b, c, nums[lo--]);
                    }
                }
                if (lo >= 0){
                    while (lo >= 0) {
                        res[idx++] = getQuadraticValue(a, b, c, nums[lo--]);
                    }
                }
                if (hi < nums.length) {
                    while (hi < nums.length) {
                        res[idx++] = getQuadraticValue(a, b, c, nums[hi++]);
                    }
                }
            }
        } else if ((mid - 1 < 0 && a > 0) || (mid >= nums.length && a < 0)) {  // in decreasing order
            for (int i = nums.length - 1; i >= 0; i--) {
                res[nums.length - i - 1] = getQuadraticValue(a, b, c, nums[i]);
            }
        } else { // in increasing order
            for (int i = 0; i < nums.length; i++) {
                res[i] = getQuadraticValue(a, b, c, nums[i]);
            }
        }
        return res;
    }
    private int getQuadraticValue(int a, int b, int c, int x) {
        return  a*(int)Math.pow(x,2) + b*x + c;
    }
    private int binarySearch(int[] nums, double target) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi - 1) {
            int mid = (hi + lo)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return nums[hi] < target?hi:lo;
    }
}
