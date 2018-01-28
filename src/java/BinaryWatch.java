package java;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by haileyyin on 1/27/18.
 */
public class BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        List<String> ans = new LinkedList<>();
        for(int i=0; i<=num; i++){
            List<Integer> hours = new LinkedList<>();
            List<Integer> minutes = new LinkedList<>();
            getTime(i, 4, new LinkedList<>(), hours);
            getTime(num-i, 6, new LinkedList<>(), minutes);
            for(int j=0; j<hours.size(); j++){
                if(hours.get(j)<12){
                    for(int k=0; k<minutes.size(); k++){
                        if(minutes.get(k)<60){
                            String minute = "" + minutes.get(k);
                            if(minute.length()==1){
                                minute = "0"+minute;
                            }
                            ans.add(hours.get(j)+":"+minute);
                        }

                    }
                }
            }
        }
        return ans;
    }

    private void getTime(int num, int length, List<Integer> cur, List<Integer> times){
        if(num>length)
            return;
        if(length==0){
            int time = 0;
            int size = cur.size();
            for(int i=0; i<size; i++){
                time+=cur.get(i)<<(size-1-i);
            }
            times.add(time);
            return;
        }
        if(num>0){
            cur.add(1);
            getTime(num-1, length-1,  cur, times);
            cur.remove(cur.size()-1);
        }
        cur.add(0);
        getTime(num, length-1,cur, times);
        cur.remove(cur.size()-1);
    }
}
