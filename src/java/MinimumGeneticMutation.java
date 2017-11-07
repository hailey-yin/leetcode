package java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by haileyyin on 11/6/17.
 */
public class MinimumGeneticMutation {
    /*
   方法一：和word ladder 一样
    */
    public int minMutation1(String start, String end, String[] bank) {
        if(start.equals(end))
            return 0;
        HashSet<String> notVisited = new HashSet<>();
        for(int i=0; i<bank.length; i++){
            notVisited.add(bank[i]);
        }
        if(notVisited.contains(start)){
            notVisited.remove(start);
        }
        Queue<String> queue = new LinkedList<>();
        int level = 1;
        char[] dictionary = {'A','G','C','T'};
        queue.offer(start);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            for(int i=0; i<levelNum; i++){
                String word = queue.poll();
                for(int j=0; j<word.length(); j++){
                    for(int k=0; k<dictionary.length; k++){
                        char[] wordUnit = word.toCharArray();
                        wordUnit[j] = dictionary[k];
                        String temp = new String(wordUnit);
                        if(notVisited.contains(temp)){
                            if(temp.equals(end)){
                                return level;
                            }
                            queue.offer(temp);
                            notVisited.remove(temp);
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }
    /*
    方法二：update，和dna那道题一样，用两个二进制位来表示四个字母，节省空间。
     */
    final HashMap<Character, Integer> inmap = new HashMap<>();
    public int minMutation2(String start, String end, String[] bank) {
        if(start.equals(end))
            return 0;
        inmap.put('A',0);
        inmap.put('C',1);
        inmap.put('G',2);
        inmap.put('T',3);
        HashSet<Integer> notVisited = new HashSet<>();
        for(int i=0; i<bank.length; i++){
            notVisited.add(encode(bank[i]));
        }
        int startValue = encode(start);
        if(notVisited.contains(startValue)){
            notVisited.remove(startValue);
        }
        Queue<String> queue = new LinkedList<>();
        int level = 1;
        char[] dictionary = {'A','G','C','T'};
        queue.offer(start);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            for(int i=0; i<levelNum; i++){
                String word = queue.poll();
                for(int j=0; j<word.length(); j++){
                    for(int k=0; k<dictionary.length; k++){
                        char[] wordUnit = word.toCharArray();
                        wordUnit[j] = dictionary[k];
                        String temp = new String(wordUnit);
                        int tempValue = encode(temp);
                        if(notVisited.contains(tempValue)){
                            if(temp.equals(end)){
                                return level;
                            }
                            queue.offer(temp);
                            notVisited.remove(tempValue);
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }

    public int encode(String str){
        int code = 0;
        for(int i=0; i<str.length(); i++){
            code = (code<<2)+inmap.get(str.charAt(i));
        }
        return code;
    }
}
