package java;

import java.util.HashSet;

/**
 * Created by haileyyin on 1/27/18.
 */
public class ReverseVowelsofaString {
    public String reverseVowels(String s) {
        HashSet<Character> hs = new HashSet<>();
        hs.add('a');
        hs.add('e');
        hs.add('i');
        hs.add('o');
        hs.add('u');
        hs.add('A');
        hs.add('E');
        hs.add('I');
        hs.add('O');
        hs.add('U');
        int i = 0;
        int j = s.length()-1;
        char[] c = s.toCharArray();
        while(i<j){
            if(!hs.contains(c[i]))
                i++;
            if(!hs.contains(c[j]))
                j--;
            if(hs.contains(c[i]) && hs.contains(c[j])){
                char temp = c[i];
                c[i] = c[j];
                c[j] = temp;
                i++;
                j--;
            }
        }
        return String.valueOf(c);
    }
}
