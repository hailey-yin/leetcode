package java;

/**
 * Created by haileyyin on 10/22/17.
 */
public class FirstMissingPositive {
    /*
    从前向后遍历数组，对每个数字i判断i是否等于A[i]。如果不满足，与处于A[i]位置的元素交换。
    最后，从前向后再次遍历数组，第一个满足i不等于A[i]的i为返回结果。
     */
    public int firstMissingPositive(int[] A) {
        if(A==null || A.length==0)
            return 1;

        for(int i=0;i<A.length;i++){
            if(A[i]<=A.length && A[i]>0 && A[A[i]-1]!=A[i]){
                int temp = A[A[i]-1];
                A[A[i]-1] = A[i];
                A[i] = temp;
                i--;
            }
        }

        for(int i=0;i<A.length;i++){
            if(A[i]!=i+1)
                return i+1;
        }

        return A.length+1;
    }
}
