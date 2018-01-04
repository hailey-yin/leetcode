package java;

/**
 * Created by haileyyin on 11/16/17.
 */
public class IsomorphicStrings {
    /*
    use a int array to store the lasest index of each character
    */
    public boolean isIsomorphic(String s, String t) {
        if(s.length()==0)
            return true;
        int[] sa = new int[176];
        int[] ta = new int[176];
        for(int i=0; i<s.length(); i++){
            int aidx = s.charAt(i);
            int bidx = t.charAt(i);
            if(sa[aidx]==ta[bidx]){
                sa[aidx] = i+1;
                ta[bidx] = i+1;
            } else {
                return false;
            }
        }
        return true;
    }
}
