package java;

/**
 * Created by haileyyin on 4/2/18.
 */
public class RansomNote {
    /*
    列出了magazine的字母表，然后算出了出现个数，然后遍历ransomNote，保证有足够的字母可用
    */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letters = new int[26];
        for(int i=0; i<magazine.length(); i++){
            letters[magazine.charAt(i)-'a']++;
        }
        for(int i=0; i<ransomNote.length(); i++){
            if(letters[ransomNote.charAt(i)-'a']<=0){
                return false;
            }
            letters[ransomNote.charAt(i)-'a']--;
        }
        return true;
    }
}
