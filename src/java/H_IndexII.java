package java;

/**
 * Created by haileyyin on 4/5/18.
 */
public class H_IndexII {
    /*
    直接就是H_Index的第一种方法,还不需要排序
    time: O(n)
    space: O(1)
     */
    public int hIndex(int[] citations) {
        int n = citations.length;
        int max = 0;
        for(int i=n-1; i>=0; i--){
            if(n-i<=citations[i])
                max = Math.max(max, n-i);
        }
        return max;
    }
}
