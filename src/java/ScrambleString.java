package java;

import java.util.Arrays;

/**
 * Created by haileyyin on 10/22/17.
 */
public class ScrambleString {
    /*
    分治思想：有多种分割，因此需要比较多种情况·。

     D(k) is defined as the boolean result between
         左            左             右          右
         X[0…k-1] and Y[0…k-1]  &&  X[k…n] and Y[k…m]
     或
         左            右              右              左
         X[0…k-1] and Y[m-k+1…m]  &&  X[n-k+1…n] and Y[0…m]
     递归实现。

    update: haspmap, key: s1+s2, value: boolean

    三围dp？？？
     */
    public boolean isScramble(String s1, String s2) {
        if(s1==null || s2==null || s1.length()!=s2.length())
            return false;
        if(s1.equals(s2))
            return true;
        char[] s1char = s1.toCharArray();
        char[] s2char = s2.toCharArray();
        Arrays.sort(s1char);
        Arrays.sort(s2char);
        String s1new = new String(s1char);
        String s2new = new String(s2char);
        if(!s1new.equals(s2new))
            return false;
        for(int cut=1; cut<s1.length(); cut++){
            String s1Left = s1.substring(0, cut);
            String s1Right = s1.substring(cut, s1.length());
            String s2Left = s2.substring(0, cut);
            String s2Right = s2.substring(cut, s2.length());
            if((isScramble(s1Left, s2.substring(0, cut)) && isScramble(s1Right, s2.substring(cut, s2.length())))
                    || (isScramble(s1Left,s2.substring(s2.length()-cut, s2.length())) && isScramble(s1Right, s2.substring(0, s2.length()-cut))))
                return true;
        }
        return false;
    }
}
