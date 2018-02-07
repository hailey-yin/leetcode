package java;

/**
 * Created by haileyyin on 2/7/18.
 */
public class ArithmeticSlices {

    public int numberOfArithmeticSlices(int[] A) {
        int curr = 0, sum = 0;
        for (int i=2; i<A.length; i++)
            if (A[i]-A[i-1] == A[i-1]-A[i-2]) {
                curr += 1;
                sum += curr;
            } else {
                curr = 0;
            }
        return sum;
    }
    /*
    考虑到步长可以增加的情况，并且相同的Arithmetic只算一次
     */
    public int numberOfArithmeticSlices2(int[] A) {
        int count = 0;
        for(int i=0; i<A.length-2; i++){
            if(i>0&&A[i]==A[i-1])
                continue;
            count += numberOfASStaringFromI(A, i);
        }
        return count;
    }

    private int numberOfASStaringFromI(int[] A, int i){
        int dis = 0;
        int start = i;
        int count = 0;
        for(int k=1; k<=(A.length-start)/2; k++){
            dis = A[start+k]-A[start];
            int cur = start+k;
            while(cur+k<A.length){
                if(A[cur+k]-A[cur]==dis){
                    count++;
                    cur += k;
                } else {
                    break;
                }
            }
        }
        return count;
    }
}
