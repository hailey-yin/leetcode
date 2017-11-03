package java;

/**
 * Created by haileyyin on 11/1/17.
 */
public class SuperUglyNumber {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] indexs = new int[primes.length];
        int[] sun = new int[n];
        sun[0] = 1;
        for(int i=1; i<n; i++){
            int min = Integer.MAX_VALUE;
            for(int j=0; j<primes.length; j++){
                min = Math.min(min, sun[indexs[j]]*primes[j]);
            }
            sun[i] = min;
            for(int j=0; j<primes.length; j++){
                if(sun[i]==sun[indexs[j]]*primes[j]) indexs[j]++;
            }
        }
        return sun[n-1];
    }

}
