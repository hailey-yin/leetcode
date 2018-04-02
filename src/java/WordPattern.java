package java;

/**
 * Created by haileyyin on 3/29/18.
 */
public class WordPattern {
    /*
    brutal force:
    walk through the string, for each character we compare it with all the characters in front of it, and do the same thing to corresponding str.
    Time: O(n!)
    Space: O(n)
    */
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if(pattern.length()!=words.length)
            return false;
        for(int i=0; i<pattern.length(); i++){
            for(int j=0; j<i; j++){
                if(pattern.charAt(i)!=pattern.charAt(j)&&words[i].equals(words[j])
                        ||pattern.charAt(i)==pattern.charAt(j)&&!words[i].equals(words[j]))
                    return false;
            }
        }
        return true;
    }
}
