package java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by haileyyin on 10/21/17.
 */
public class RepeatedDNASequences {
    /*
    方法一：哈希表
    时间复杂度 O(n), 由于HashMap中存储了所有长度为10的子串，所以空间复杂度O(10n)。
     */

    public List<String> findRepeatedDnaSequences1(String s) {
        List<String> res = new ArrayList<>();
        HashMap<String, Integer> hmap = new HashMap<>();
        for(int i=0; i<=s.length()-10; i++){
            String sub = s.substring(i,i+10);
            if(hmap.get(sub)==null){
                hmap.put(sub, 1);
            } else if(hmap.get(sub)==1){
                hmap.put(sub, 2);
                res.add(sub);
            }
        }
        return res;
    }

    /*
    方法二：位操作，编码
    实际上我们的哈希表可以不用存整个子串，因为我们知道子串只有10位，且每一位只可能有4种不同的字母，
    如果用用每两位bit表示一个字符，那十个字母就是20个bit，小于32个bit，即一个integer的字节单位，
    所以我们可以用一个Integer来表示。具体的编码方法是用每两位bit表示一个字符。

    老郭update：
    随着substring的位置向后移，每个substring的value可以通过对前一个substring的处理得到。
     */

    final HashMap<Character, Integer> inmap = new HashMap<>();

    public List<String> findRepeatedDnaSequences2(String s) {
        List<String> res = new ArrayList<>();
        HashMap<Integer, Integer> hmap = new HashMap<>();

        inmap.put('A',0);
        inmap.put('C',1);
        inmap.put('G',2);
        inmap.put('T',3);

        for(int i=0; i<=s.length()-10; i++){
            String sub = s.substring(i,i+10);
            int num = encode(sub);
            if(hmap.get(num)==null){
                hmap.put(num, 1);
            } else if(hmap.get(num)==1){
                hmap.put(num, 2);
                res.add(sub);
            }
        }
        return res;
    }

    public int encode(String str){
        int code = 0;
        for(int i=0; i<str.length(); i++){
            code = (code<<2)+inmap.get(str.charAt(i));
        }
        return code;
    }

}
