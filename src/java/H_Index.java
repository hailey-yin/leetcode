package java;

import java.util.Arrays;

/**
 * Created by haileyyin on 4/5/18.
 */
public class H_Index {
    /*
    sort
    Time: O(nlogn)
    Space: O(1)
    */
    public int hIndex(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        int max = 0;
        for(int i=n-1; i>=0; i--){
            if(n-i<=citations[i])
                max = Math.max(max, n-i);
        }
        return max;
    }
    /*
    Time: O(n)
    Space: O(n)

    After finalizing the counts vector, we can then easily locate his h-index by scanning from right (L) to left (0).
    By definition, index k is his h-index if the summation of all elements from counts[k] to counts[L] is no less than k.
    */
    public int hIndex2(int[] citations) {
        int L = citations.length;
        if(L<1) return 0;
        int[] counts = new int[L+1];
        for(int i : citations) {
            if(i>L) counts[L]++;
            else counts[i]++;
        }
        int res = 0;
        for(int k=L; k>=0; k--) {
            res += counts[k];
            if(res>=k) return k;
        }
        return 0;
    }
}
