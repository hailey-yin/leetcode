package java;

import java.util.Stack;

/**
 * Created by haileyyin on 3/27/18.
 */
public class DecodeString {
    /*
    s = "3[a]2[bc]"
    push     stack: 3[a]2[bc]               layer 0
    pop ]    stack: 3[a]2[bc                layer 1
    pop c    stack: 3[a]2[b    temp:c       layer 1
    pop b    stack: 3[a]2[     temp:bc      layer 1
    pop [    stack: 3[a]2      temp:bc      layer 0
    pop 2    stack: 3[a]       temp:bcbc    layer 0         res:bcbc
    pop ]    stack: 3[a        temp:        layer 1         res:bcbc
    pop a    stack: 3[         temp:a       layer 1         res:bcbc
    pop [    stack: 3          temp:a       layer 0         res:bcbc
    pop 3    stack:            temp:aaa     layer 0         res:aaabcbc

    s = "3[a2[c]]"
    push     stack: 3[a2[c]]                layer 0
    pop ]    stack: 3[a2[c]                 layer 1
    pop ]    stack: 3[a2[c                  layer 2
    pop c    stack: 3[a2[       temp:c      layer 2
    pop [    stack: 3[a2        temp:c      layer 1
    pop 2    stack: 3[a         temp:cc     layer 1         push back into stack
             stack: 3[acc
    pop c    stack: 3[ac        temp:c      layer 1
    pop c    stack: 3[a         temp:cc     layer 1
    pop a    stack: 3[          temp:acc    layer 1
    pop [    stack: 3           temp:acc    layer 1
    pop 3    stacl:             temp:accaccacc layer 0      res: accaccacc

    s = "3[4[a]2[c]]"
    push     stack: 3[4[a]2[c]]             layer 0
    pop ]    stack: 3[4[a]2[c]              layer 1
    pop ]    stack: 3[4[a]2[c               layer 2
    pop c    stack: 3[4[a]2[    temp:c      layer 2
    pop [    stack: 3[4[a]2     temp:c      layer 1
    pop 2    stack: 3[4[a]      temp:cc     layer 1

    错误

    用两个stack解决问题
    */
    public String decodeString(String s) {
        String res = new String();
        Stack<Integer> s1 = new Stack<>();
        Stack<String> s2 = new Stack<>();
        int idx = 0;
        while(idx<s.length()){
            if(Character.isDigit(s.charAt(idx))){
                //重复数字超过10的情况
                int count = 0;
                while(Character.isDigit(s.charAt(idx))){
                    count = count*10+(s.charAt(idx)-'0');
                    idx++;
                }
                s1.push(count);
            } else if(s.charAt(idx)=='['){
                s2.push(res);
                res = "";
                idx++;
            } else if(s.charAt(idx)==']'){
                StringBuilder temp = new StringBuilder(s2.pop());
                int time = s1.pop();
                for(int i=0; i<time; i++){
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            } else {
                res += s.charAt(idx);
                idx++;
            }
        }
        return res;
    }
}
