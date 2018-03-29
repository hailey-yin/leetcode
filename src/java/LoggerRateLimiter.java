package java;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Created by haileyyin on 3/5/18.
 */
public class LoggerRateLimiter {
    /*
    using a hashmap of String that maps to the recent time stamp.
    time: O(n)
    space: O(n)
    problems if the word varies a lot each time, the hashset might end up very large.
    it needs to keep the record of the entire messages, even when the message is rare.
     */
    HashMap<String, Integer> hm = new HashMap<>();
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(hm.containsKey(message) && timestamp-hm.get(message)<10){
            return false;
        } else {
            return true;
        }
    }
    /*
    update: priorityqueue
    wrong: It is possible that several messages arrive roughly at the same time. Therefore we do not know the volumn of the pool.
     */
    PriorityQueue<Log> pq = new PriorityQueue<>(10, new Comparator<Log>() {
        @Override
        public int compare(Log o1, Log o2) {
            return o1.timestamp - o2.timestamp;
        }
    });
    HashSet<String> hs = new HashSet<>();
    public boolean shouldPrintMessage2(int timestamp, String message) {
        // discard the logs older than 10 minutes
        while(pq.size()>0){
            Log log = pq.peek();
            if(timestamp-log.timestamp>=10){
                pq.poll();
                hs.remove(log.message);
            } else {
                break;
            }
        }
        boolean res = !hs.contains(message);
        if(res){
            pq.add(new Log(timestamp, message));
            hs.add(message);
        }
        return res;
    }
}
