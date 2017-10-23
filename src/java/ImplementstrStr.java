package java;

/**
 * Created by haileyyin on 10/21/17.
 */
public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        if (needle.equals("")){
            return 0;
        }
        String[] array = haystack.split("");
        int n = haystack.length();
        int m = needle.length();
        if (n<m)
            return -1;
        for(int i=0; i<n-m+1; i++){
            for(int j=0; j<m; j++){
                if (haystack.charAt(i+j)!=(needle.charAt(j)))
                    break;
                else
                if (j==m-1)
                    return i;
            }
        }
        return -1;
    }
}
