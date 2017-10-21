package java;

import java.util.HashMap;
import java.util.List;

/**
 * Created by haileyyin on 10/21/17.
 */
public class LetterCombinationsofaPhoneNumber {
    final HashMap<Character, Character[]> hmap = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        List<String> res = null;
        hmap.put('1',new Character[] {});
        hmap.put('2',new Character[] {});
        hmap.put('3',new Character[] {});
        hmap.put('4',new Character[] {});
        hmap.put('5',new Character[] {});
        hmap.put('6',new Character[] {});
        hmap.put('6',new Character[] {});

        return res;
    }
}
