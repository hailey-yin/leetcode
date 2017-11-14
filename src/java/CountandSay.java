package java;

/**
 * Created by haileyyin on 11/13/17.
 */
public class CountandSay {
    public String countAndSay(int n) {
        if(n<=0){
            return "";
        }
        String ans = "1";
        while(n>1){
            ans = helper(ans);
            n--;
        }
        return ans;
    }

    private String helper(String ans){
        char[] c = ans.toCharArray();
        int count = 0;
        char curr = Character.MIN_VALUE;
        String temp = "";
        for(int i=0; i<c.length; i++){
            if(c[i]!=curr){
                if(count!=0){
                    temp += count + "" + curr;
                }
                curr = c[i];
                count = 1;
            } else {
                count++;
            }
        }
        temp += count + "" + curr;
        return temp;
    }
}
