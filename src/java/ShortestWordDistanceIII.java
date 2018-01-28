package java;

/**
 * Created by haileyyin on 1/26/18.
 */
public class ShortestWordDistanceIII {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int lastIdx = -1;
        int min = Integer.MAX_VALUE;
        if(!word1.equals(word2)){
            for(int i=0; i<words.length; i++){
                if(words[i].equals(word1)||words[i].equals(word2)){
                    if(lastIdx!=-1 && !words[i].equals(words[lastIdx])){
                        min = Math.min(min, i-lastIdx);
                    }
                    lastIdx = i;
                }

            }
        } else {
            for(int i=0; i<words.length; i++){
                if(words[i].equals(word1)){
                    if(lastIdx!=-1){
                        min = Math.min(min, i-lastIdx);
                    }
                    lastIdx = i;
                }

            }
        }
        return min;
    }
}
