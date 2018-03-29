package java;

/**
 * Created by haileyyin on 3/26/18.
 */
public class NthDigit {
    /*
    find the mathematic law
    1-9              9*1
    10-99            90*2
    100-999          900*3
    1000-9999        9000*4
    10000-99999      90000*5
    100000-          900000*6
    1000000-         9000000*7
    10000000-        90000000*8
    100000000-       900000000*9
    1000000000-      1147483748
    2147483647

    Straight forward way to solve the problem in 3 steps:

    1. find the length of the number where the nth digit is from
    2. find the actual number where the nth digit is from
    3. find the nth digit and return

    注意：
    count数据类型要用long，如果用int的话，当n=Integer.MAX_VALUE 即2147483647时会报错
    Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: -13
	at java.lang.String.charAt(String.java:615)
	at Solution.findNthDigit(Solution.java:34)
	at __DriverSolution__.__helper__(__Driver__.java:4)
	at __Driver__.main(__Driver__.java:48)

    n:2147483647,len:1,count:9
    n:2147483638,len:2,count:90
    n:2147483458,len:3,count:900
    n:2147480758,len:4,count:9000
    n:2147444758,len:5,count:90000
    n:2146994758,len:6,count:900000
    n:2141594758,len:7,count:9000000
    n:2078594758,len:8,count:90000000
    n:1358594758,len:9,count:900000000
    n:1848529350,len:10,count:410065408
    n:2042842566,len:11,count:-194313216
    n:-114679354,len:12,count:-1943132160
    n:1728070086,len:13,count:2043514880
    n:932180422,len:14,count:-1039687680
    */
    public int findNthDigit(int n) {
        int len = 1;
        long count = 9;
        int start = 1;
        while(n>len*count){
            n -= len*count;
            len++;
            count *= 10;
            start *= 10;
        }
        start += (n - 1) / len;
        String s = Integer.toString(start);
        return Character.getNumericValue(s.charAt((n - 1) % len));
    }
}
