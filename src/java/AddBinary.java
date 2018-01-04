package java;

/**
 * Created by haileyyin on 11/16/17.
 */
public class AddBinary {
    /*
    runtime error
    if strings exceed integer range
     */
    public String addBinary1(String a, String b) {
        if(a.length()==0){
            return b;
        }
        if(b.length()==0)
            return a;
        int sum = Integer.parseInt(a,2)+Integer.parseInt(b,2);
        StringBuilder sb = new StringBuilder();
        int highest = -1;
        for(int i=31; i>=0; i--){
            if(highest==-1&&(((sum>>i)&1)==1)){
                highest = i;
            }
            sb.append((sum>>i)&1);
        }
        if(highest == -1)
            return "0";
        return sb.toString().substring(32-highest-1);
    }

    /*
    simulate adding process
    rumtime complexity: O(max(m,n))
    space complexity: O(max(m,n))
     */
    public String addBinary(String a, String b) {
        int m = a.length();
        int n = b.length();
        if(m==0)
            return b;
        if(n==0)
            return a;
        StringBuilder sb = new StringBuilder();
        int minLen = m;
        if(m>n)
            minLen = n;
        int overflow = 0;
        for(int i=0; i<minLen; i++){
            int ai = Character.getNumericValue(a.charAt(m-i-1));
            int bi = Character.getNumericValue(b.charAt(n-i-1));
            sb.append((ai+bi+overflow)%2);
            overflow = (ai+bi+overflow)/2;
        }
        if(minLen==m){
            for(int i=minLen; i<n; i++){
                int bi = Character.getNumericValue(b.charAt(n-i-1));
                sb.append((bi+overflow)%2);
                overflow = (bi+overflow)/2;
            }
        } else {
            for(int i=minLen; i<m; i++){
                int ai = Character.getNumericValue(a.charAt(m-i-1));
                sb.append((ai+overflow)%2);
                overflow = (ai+overflow)/2;
            }
        }
        while(overflow>0){
            sb.append(overflow%2);
            overflow /= 2;
        }
        return sb.reverse().toString();
    }
}
