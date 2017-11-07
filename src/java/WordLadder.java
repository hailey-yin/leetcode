package java;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by haileyyin on 11/6/17.
 */
public class WordLadder {
    /*
    bfs
    如何找到与当前节点相邻的所有节点。
    (1) 遍历整个字典，将其中每个单词与当前单词比较，判断是否只差一个字符。复杂度为：n*w，n为字典中的单词数量，w为单词长度。
    (2) 遍历当前单词的每个字符x，将其改变成a~z中除x外的任意一个，形成一个新的单词，在字典中判断是否存在。复杂度为：26*w，w为单词长度。
    这里可以和面试官讨论两种策略的取舍。对于通常的英语单词来说，长度大多小于100，而字典中的单词数则往往是成千上万，所以策略2相对较优。

    2. 如何标记一个节点已经被访问过，以避免重复访问。
    可以将访问过的单词从字典中删除。

    3. 一旦BFS找到目标单词，如何backtracking找回路径？
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord))
            return 0;
        HashSet<String> notVisited = new HashSet<>(wordList);
        if(notVisited.contains(beginWord)){
            notVisited.remove(beginWord);
        }
        Queue<String> queue = new LinkedList<>();
        int level = 1;
        queue.offer(beginWord);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            for(int i=0; i<levelNum; i++){
                String word = queue.poll();
                for(int j=0; j<word.length(); j++){
                    char[] wordUnit = word.toCharArray();
                    for(char k='a'; k<='z'; k++){
                        wordUnit[j] = k;
                        String temp = new String(wordUnit);
                        if(notVisited.contains(temp)){
                            if(temp.equals(endWord)){
                                return level+1;
                            }
                            queue.offer(temp);
                            notVisited.remove(temp);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
