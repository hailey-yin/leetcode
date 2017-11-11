package java;

/**
 * Created by haileyyin on 11/10/17.
 */
public class LongestCommonPrefix {
    /*
   time complexity: O(n)
   space complexity: O(1)
    */
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        int index = strs[0].length();
        for(int i=0; i< strs.length-1; i++){
            index = Math.min(index, strs[i+1].length());
            while(index>0 &&!strs[i].substring(0, index).equals(strs[i+1].substring(0, index))){
                index--;
            }
        }
        return strs[0].substring(0, index);
    }
}
