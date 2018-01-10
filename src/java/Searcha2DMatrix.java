package java;

/**
 * Created by haileyyin on 1/9/18.
 */
public class Searcha2DMatrix {
    /*
    using binary search two times, one for row search and one for column search
    */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0 || matrix[0].length==0)
            return false;
        if(matrix.length==1 && matrix[0].length==1){
            if(matrix[0][0]==target){
                return true;
            } else {
                return false;
            }
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m-1;
        while(low<high){
            int mid = low + (high-low)/2;
            if(matrix[mid][0]==target){
                return true;
            } else if(matrix[mid][0]<target){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        int row = 0;
        if(matrix[low][0]<target){
            row = low;
        } else if(matrix[low][0]>target && low>0){
            row = low-1;
        } else if(matrix[low][0]==target){
            return true;
        } else {
            return false;
        }
        low = 0;
        high = n-1;
        while(low<=high ){
            int mid = low + (high-low)/2;
            if(matrix[row][mid]==target){
                return true;
            } else if(matrix[row][mid]<target){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return false;
    }
}
