package java;

/**
 * Created by haileyyin on 1/25/18.
 */
public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int idx1 = -1;
        int idx2 = -1;
        int sd = Integer.MAX_VALUE;
        for(int i=0; i<words.length; i++){
            if(words[i].equals(word1)){
                idx1 = i;
                if(idx2!=-1){
                    sd = Math.min(sd, idx1-idx2);
                }
            } else if(words[i].equals(word2)){
                idx2 = i;
                if(idx1!=-1){
                    sd = Math.min(sd, idx2-idx1);
                }
            }
        }
        return sd;
    }
}
