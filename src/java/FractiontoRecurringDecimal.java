package java;

import java.util.HashMap;

/**
 * Created by haileyyin on 5/1/18.
 */
public class FractiontoRecurringDecimal {
    // 1. 0 + - overflow
    // 2. 整数
    // 3. 小数(hashmap处理重复部分)
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator==0)
            return "0";
        StringBuilder sb = new StringBuilder();
        sb.append(((numerator>0)^(denominator>0))?"-":"");
        long n = Math.abs((long) numerator);        //(long) Math.abs();出错, 比如Math.abs(Integer.MIN_VALUE)返回-2147483648
        long d = Math.abs((long) denominator);
        sb.append(n/d);
        n %= d;
        if (n == 0) {
            return sb.toString();
        }
        sb.append(".");
        HashMap<Long, Integer> hm = new HashMap<>();
        hm.put(n, sb.length());
        while (n != 0) {
            n *= 10;
            sb.append(n/d);
            n %= d;
            if (hm.containsKey(n)) {
                sb.insert(hm.get(n), "(");
                sb.append(")");
                break;
            } else {
                hm.put(n, sb.length());
            }
        }
        return sb.toString();
    }
}
