package java;

/**
 * Created by haileyyin on 4/22/18.
 */
public class OneEditDistance {
    /*
    edit: delete, add, modify
    abc    abc    abc
    abdc   ac     acc

    s[i]==t[j] check next chars of t and s
    s[i]!=t[j] check if s[i+1...m]==t[j+1...m] or s[i+1...m]==t[j...m] or s[i...m]==t[j+1...m]

    note that there must be one edit operation between s and t.
    */
    public boolean isOneEditDistance(String s, String t) {
        for(int i=0; i<Math.min(s.length(), t.length()); i++){
            if(s.charAt(i)!=t.charAt(i)){
                return s.substring(i + 1).equals(t.substring(i + 1))
                        || s.substring(i).equals(t.substring(i + 1))
                        || t.substring(i).equals(s.substring(i + 1));
            }
        }
        return Math.abs(s.length() - t.length()) == 1;
    }
}
