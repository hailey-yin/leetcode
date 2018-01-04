package java;

/**
 * Created by haileyyin on 11/14/17.
 */
public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        if(s.length()==0)
            return 0;
        String[] sa = s.split(" ");

        return sa.length>0?sa[sa.length-1].length():0;
    }
}
