package java;

/**
 * Created by haileyyin on 11/3/17.
 */
//307. Range Sum Query - Mutable
public class NumArray {
     /*
    Time Limit Exceeded:
     */
//    int[] nums;
//    public NumArray(int[] nums) {
//        this.nums = nums.clone();
//    }
//    public void update(int i, int val) {
//        nums[i] = val;
//    }
//    public int sumRange(int i, int j) {
//        int sum = 0;
//        for(int k=i; k<=j ;k++){
//            sum += nums[k];
//        }
//        return sum;
//    }

    /*
    binary index tree solution
    https://www.youtube.com/watch?v=v_wj_mOAlig
     */
//    int[] bitArray;
//    int[] numscopy;
//    int n;
//
//    public NumArray(int[] nums) {
//        numscopy = nums;
//        n = nums.length;
//        bitArray = new int[n+1];
//        for(int i=0; i<n; i++){
//            int index = i+1;
//            while(index<=n){
//                bitArray[index] += numscopy[i];
//                index += (index&-index);
//            }
//        }
//    }
//
//    public void update(int i, int val) {
//        int index = i+1;
//        int dis = val-numscopy[i];
//        numscopy[i] = val;
//        while(index<=n){
//            bitArray[index] += dis;
//            index += (index&-index);
//        }
//    }
//
//    public int sumRange(int i, int j) {
//        return getSum(j)-getSum(i-1);
//    }
//
//    private int getSum(int i){
//        int sum = 0;
//        int index = i+1;
//        while(index>0){
//            sum += bitArray[index];
//            index -= (index&-index);
//        }
//        return sum;
//    }

    /*
    segment tree solution
    https://www.youtube.com/watch?v=ZBHKZF5w4YU&t=640s
     */
    static class SegmentTree
    {
        SegmentTree left, right;
        int start, end;
        int sum;
        SegmentTree(int start, int end)
        {
            left = null;
            right = null;
            this.start = start;
            this.end = end;
            sum = 0;
        }
    }

    SegmentTree root = null;

    public SegmentTree constructSegmentTree(int[] nums, int start, int end)
    {

        if(start > end)
        {
            return null;
        }
        SegmentTree st  = new SegmentTree(start, end);
        if(start == end)
        {
            st.sum = nums[start];
            return st;
        }
        else
        {
            int mid = start + (end - start)/2;
            st.left = constructSegmentTree(nums, start, mid);
            st.right = constructSegmentTree(nums, mid+1, end);
            st.sum = st.left.sum + st.right.sum;
        }
        return st;

    }

    public NumArray(int[] nums)
    {
        root = constructSegmentTree(nums, 0, nums.length-1);
    }

    public void updateTree(SegmentTree root, int i, int val)
    {
        if(root.start == root.end)
        {
            root.sum = val;
        }
        else
        {
            int mid = root.start + (root.end - root.start)/2;
            if(i > mid)
            {
                updateTree(root.right, i, val);
            }
            else
            {
                updateTree(root.left, i, val);

            }
            root.sum = root.left.sum + root.right.sum;
        }
    }

    public void update(int i, int val)
    {
        updateTree(root, i, val);
    }

    public int sumRangeTree(SegmentTree root, int i, int j)
    {
        if(root.start == i && root.end == j) return root.sum;
        if(root.start == root.end)
            return root.sum;
        int mid = root.start + (root.end - root.start)/2;
        if(i > mid) return sumRangeTree(root.right, i ,j);
        else if(j <= mid) return sumRangeTree(root.left, i , j);
        else return sumRangeTree(root.left, i , mid) + sumRangeTree(root.right, mid+1, j);
    }


    public int sumRange(int i, int j)
    {
        return sumRangeTree(root, i, j);
    }
}
