package java;

import java.util.TreeSet;

/**
 * Created by haileyyin on 7/10/18.
 */
public class MaxSumofRectangleNoLargerThanK {
    /*
    time: O(N^2Mlog(M))
     */
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix==null||matrix.length==0||matrix[0].length==0)
            return 0;
        int m=matrix.length;
        int n=matrix[0].length;
        int result = Integer.MIN_VALUE;
        for(int c1=0; c1<n; c1++){
            int[] each = new int[m];
            for(int c2=c1; c2>=0; c2--){
                for(int r=0; r<m; r++){
                    each[r]+=matrix[r][c2];
                }
                result = Math.max(result, getLargestSumCloseToK(each, k));
            }
        }
        return result;
    }
    public int getLargestSumCloseToK(int[] arr, int k){
        int sum=0;
        TreeSet<Integer> set = new TreeSet<Integer>();
        int result=Integer.MIN_VALUE;
        set.add(0);
        for(int i=0; i<arr.length; i++){
            sum=sum+arr[i];
            Integer ceiling = set.ceiling(sum-k);
            if(ceiling!=null){
                result = Math.max(result, sum-ceiling);
            }
            set.add(sum);
        }
        return result;
    }
    /*
    brutal force
    time: O(n^4)
     */
    public int maxSumSubmatrix2(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int rows = matrix.length, cols = matrix[0].length;
        int[][] areas = new int[rows][cols];
        //计算每个元素到左上角元素的和，方便后面使用
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int area = matrix[r][c];
                if (r-1 >= 0)
                    area += areas[r-1][c];
                if (c-1 >= 0)
                    area += areas[r][c-1];
                if (r-1 >= 0 && c-1 >= 0)
                    area -= areas[r-1][c-1];
                areas[r][c] = area;
            }
        }
        int max = Integer.MIN_VALUE;
        for (int r1 = 0; r1 < rows; r1++) {
            for (int c1 = 0; c1 < cols; c1++) {
                //遍历数组中的每一个元素，然后下面两个循环是得到其所有可能的矩阵
                for (int r2 = r1; r2 < rows; r2++) {
                    for (int c2 = c1; c2 < cols; c2++) {
                        //计算当前矩阵的和
                        int area = areas[r2][c2];
                        if (r1-1 >= 0)
                            area -= areas[r1-1][c2];
                        if (c1-1 >= 0)
                            area -= areas[r2][c1-1];
                        if (r1-1 >= 0 && c1 -1 >= 0)
                            area += areas[r1-1][c1-1];
                        if (area <= k)
                            max = Math.max(max, area);
                    }
                }
            }
        }
        return max;
    }
}
