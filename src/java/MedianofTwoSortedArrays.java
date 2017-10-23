package java;

/**
 * Created by haileyyin on 10/22/17.
 */
public class MedianofTwoSortedArrays {
    /*
    This problem can be converted to the problem of finding kth element, k is (A's length + B' Length)/2.
    该问题可以转换为寻找并判断两个sorted array中第k/2大的数。
    如果总长度是奇数，求第(m+n)/2+1; 如果是偶数，求第(m+n)/2和(m+n)/2+1的平均数。

    我们需要判断A[k/2-1]和B[k/2-1]的大小。
    如果A[k/2-1]==B[k/2-1]，那么这个数就是两个数组中第k大的数。
    如果A[k/2-1]<B[k/2-1], 那么说明A[0]到A[k/2-1]都不可能是第k大的数，所以需要舍弃这一半，继续从A[k/2]到A[A.length-1]继续找。当然，因为这里舍弃了A[0]到A[k/2-1]这k/2个数，那么第k大也就变成了，第k-k/2个大的数了。
    如果 A[k/2-1]>B[k/2-1]，就做之前对称的操作就好。

    边界条件，需要判断是否有一个数组长度为0，以及k==1时候的情况。
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int total = m+n;
        if(total%2 != 0){
            return (double) findKth(A, 0, m-1, B, 0, n-1, total/2+1);
        } else {
            double x = findKth(A, 0, m-1, B, 0, n-1, total/2);
            double y = findKth(A, 0, m-1, B, 0, n-1, total/2+1);
            return (double)(x+y)/2;
        }
    }

    public int findKth(int[] A, int astart, int aend, int[] B, int bstart, int bend, int k) {
        int m = aend - astart + 1;
        int n = bend - bstart + 1;
        if (m > n)
            return findKth(B,bstart,bend,A,astart,aend,k);
        if(m==0)
            return B[k-1];
        if(k==1)
            return Math.min(A[astart],B[bstart]);

        int partA = Math.min(k/2,m);
        int partB = k - partA;
        if(A[astart+partA-1] < B[bstart+partB-1])
            return findKth(A,astart+partA,aend,B,bstart,bend,k-partA);
        else if(A[astart+partA-1] > B[bstart+partB-1])
            return findKth(A,astart,aend,B,bstart+partB,bend,k-partB);
        else
            return A[astart+partA-1];
    }
}
