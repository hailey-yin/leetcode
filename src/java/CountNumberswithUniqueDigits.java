package java;

/**
 * Created by haileyyin on 3/5/18.
 */
public class CountNumberswithUniqueDigits {
    /*
     Let f(n) = count of number with unique digits of length n.
     f(1) = 10. (0, 1, 2, 3, …, 9)
     f(2) = 9 * 9.
     f(3) = f(2) * 8 = 9 * 9 * 8.
     Similarly f(4) = f(3) * 7 = 9 * 9 * 8 * 7…
     …
     f(10) = 9 * 9 * 8 * 7 * 6 * … * 1
     f(11) = 0 = f(12) = f(13)…
     any number with length > 10 couldn’t be unique digits number.
     The problem is asking for numbers from 0 to 10^n. Hence return f(1) + f(2) + … + f(n)
     Time: O(n)
     Space: O(1)
     */
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0)
            return 1;
        int res = 10;
        int uniqueDigits = 9;
        int availableNumber = 9;
        while(n-->1 && availableNumber>0){
            uniqueDigits *= availableNumber;
            res += uniqueDigits;
            availableNumber--;
        }
        return res;
    }
}
