package java;

/**
 * Created by haileyyin on 10/22/17.
 */
public class MaximumProductofWordLengths {
    //对每个string建立一个二进制数，用来表示string包含的字母。从高位到低位分别代表z-a，如果存在为1，否则为0。
    public int maxProduct(String[] words) {
        int max = 0;
        int n = words.length;
        int[] elements = new int[n];
        for(int i=0; i<n; i++){
            for(int j=0; j<words[i].length(); j++){
                elements[i] |= 1<<(words[i].charAt(j)-'a');
            }
        }
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if((elements[i]&elements[j])==0){
                    max = Math.max(max, words[i].length()*words[j].length());
                }
            }
        }
        return max;
    }
}
