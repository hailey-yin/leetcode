package java;

/**
 * Created by haileyyin on 4/16/18.
 */
public class ReverseWordsinaString {
    /*corner case:
    ""    arr.length==0
    " "   arr.length==0
    "a"   arr.length==1 "a"
    " 1"  arr.length==2 "","1"
    */
    public String reverseWords(String s) {
        if(s.length()==0)
            return "";
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=arr.length-1; i>=0; i--){
            if(arr[i].length()!=0){
                sb.append(arr[i]);
                sb.append(" ");
            }
        }
        String res = sb.toString();
        return res.length()==0? res:res.substring(0, res.length()-1);
    }
}
