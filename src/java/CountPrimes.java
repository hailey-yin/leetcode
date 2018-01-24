package java;

/**
 * Created by haileyyin on 1/23/18.
 */
public class CountPrimes {
    /*
    time limit exceed
     */
    public int countPrimes(int n) {
        if(n<3)
            return 0;
        if(n<5)
            return n-2;
        int ans = 2;
        for(int i=4; i<n; i++){
            if(isPrimes(i))
                ans++;
        }
        return ans;
    }

    private boolean isPrimes(int n){
        for(int i=2; i<=n/2; i++){
            if(n%i==0)
                return false;
        }
        return true;
    }
    /*
    update: 从2开始遍历到根号n，先找到第一个质数2，然后将其所有的倍数全部标记出来，然后到下一个质数3，标记其所有倍数，一次类推，直到根号n，此时数组中未被标记的数字就是质数。
     */
    public int countPrimes2(int n) {
        boolean[] isPrimes = new boolean[n];
        int count = 0;
        for(int i=2; i<n; i++){
            if(!isPrimes[i])
                count++;
            for(int j=2; i*j<n; j++){
                isPrimes[i*j]=true;
            }
        }
        return count;
    }

}
