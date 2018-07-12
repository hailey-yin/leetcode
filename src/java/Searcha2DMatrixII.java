package java;

/**
 * Created by haileyyin on 6/25/18.
 */
public class Searcha2DMatrixII {
    /*
    using two binary searches.
    The first time is to find that which rows might contain the target number.
    The second time is to find the exact number in each rows we find in the previous step.
    Time: O(logm+mlogn)
    Space: O(1)
    */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        // the first binary search is to find the last row in which the first element is smaller than the target.
        int lo = 0, hi = m - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        for (int i = 0; i <= hi; i++) {
            int le = 0, ri = n - 1;
            while (le <= ri) {
                int mid = (le + ri) / 2;
                if (matrix[i][mid] == target) {
                    return true;
                } else if (matrix[i][mid] < target) {
                    le = mid + 1;
                } else {
                    ri = mid - 1;
                }
            }
        }
        return false;
    }
}
