package java;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by haileyyin on 11/2/17.
 */
public class FirstUniqueCharacterinaString {
     /*
        方法一：遍历字符串，将字符与index作为键值对放进hashmap中，如果重复出现value设为-1，最后将所有-1的key删除，取最小value。
        ConcurrentModificationException:
        This will occur if the underlying collection that is being iterated over is modified by anything other than the Iterator itself.

        for(Map.Entry<Character, Integer> entry:hmap.entrySet()){
            if(entry.getValue()<0)
                hmap.remove(entry.getKey());
        }

        or

        Iterator it = hmap.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry item = (Map.Entry)it.next();
            if((int)item.getValue()<0){
                hmap.remove(item.getKey());
            }
        }

        Therefore, use ConcurrentHashMap instead.
        但是leetcode无法识别ConcurrentHashMap？？？？
     */

    public int firstUniqChar1(String s) {
        ConcurrentHashMap<Character, Integer> hmap = new ConcurrentHashMap<Character, Integer>();
        char[] chars = s.toCharArray();
        for(int i=0; i<chars.length; i++){
            if(hmap.get(chars[i])!=null && hmap.get(chars[i])!=-1){
                hmap.put(chars[i],-1);
            } else {
                hmap.put(chars[i],i);
            }
        }

        Iterator it = hmap.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry item = (Map.Entry)it.next();
            if((int)item.getValue()<0){
                hmap.remove(item.getKey());
            }
        }
        return Collections.min(hmap.values());
    }

    /*
    方法二：遍历字符串，将字符与index作为键值对放进hashmap中，如果重复出现value设为Integer.MAX_VALUE，最后最小value。

    注意：如果hashmap中如果没有键值对，取min时不会为空，直接报错NoSuchElementException
     */

    public int firstUniqChar2(String s) {
        if(s.length()==0)
            return -1;
        int ans = 0;
        HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
        char[] chars = s.toCharArray();
        for(int i=0; i<chars.length; i++){
            if(hmap.get(chars[i])!=null){
                hmap.put(chars[i],Integer.MAX_VALUE);
            } else {
                hmap.put(chars[i],i);
            }
        }
        ans = Collections.min(hmap.values());
        return ans==Integer.MAX_VALUE? -1:ans;
    }
}
