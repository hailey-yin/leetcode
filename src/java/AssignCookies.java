package java;

import java.util.Arrays;

/**
 * Created by haileyyin on 1/27/18.
 */
public class AssignCookies {
    /*
    for each cookie, assign it to the children with biggest appetite it can satisfy.
    */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count=0;
        int gIndex = g.length-1;
        for(int i=s.length-1; i>=0; i--){
            while(gIndex>=0){
                if(g[gIndex]<=s[i]){
                    count++;
                    gIndex--;
                    break;
                }
                gIndex--;
            }
            if(gIndex<0)
                break;
        }
        return count;
    }
}
