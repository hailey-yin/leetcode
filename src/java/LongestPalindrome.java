package java;

import java.util.HashSet;

/**
 * Created by haileyyin on 2/7/18.
 */
public class LongestPalindrome {
    /*
    hashset
    Space O(26*2)
    Time O(n)
     */
    public int longestPalindrome(String s) {
        if(s==null || s.length()==0) return 0;
        HashSet<Character> hs = new HashSet<Character>();
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(hs.contains(s.charAt(i))){
                hs.remove(s.charAt(i));
                count++;
            }else{
                hs.add(s.charAt(i));
            }
        }
        if(!hs.isEmpty()) return count*2+1;
        return count*2;
    }

    /*
    array
    Space O(256)
    Time O(n)
     */
    public int longestPalindrome2(String s) {
        int[] array = new int[256];
        for(int i=0; i<s.length(); i++){
            array[s.charAt(i)-'A']++;
        }
        int countTwice = 0;
        int countOnce = 0;
        for(int i=0; i<256; i++){
            if(countOnce==0&&array[i]%2==1){
                countOnce = 1;
            }
            if(array[i]%2==0||(array[i]-1>0&(array[i]-1)%2==0))
                countTwice += array[i]/2;
        }
        return countOnce+2*countTwice;
    }

}
