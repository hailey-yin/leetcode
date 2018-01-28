package java;

import java.util.*;

/**
 * Created by haileyyin on 1/26/18.
 */
public class TaskScheduler {
    /*
    wrong: not the minimum number of intervals
    */
    public int leastInterval(char[] tasks, int n) {
        Queue<Character> queue = new LinkedList<>();
        List<Character> list = new LinkedList<>();
        for(int i=0; i<tasks.length; i++){
            boolean flag = true;
            int size = list.size();
            for(int j=size-1; j>=Math.max(0, size-n); j--){
                if(size-j>=0 && tasks[i]==list.get(j)){
                    flag=false;
                }
            }
            if(flag){
                list.add(tasks[i]);
            } else {
                queue.offer(tasks[i]);
            }
        }
        while(!queue.isEmpty()){
            int size1 = queue.size();
            boolean needIdel = true;
            for(int k=0; k<size1; k++){
                char temp = queue.poll();
                boolean flag = true;
                int size = list.size();
                for(int j=size-1; j>=Math.max(0, size-n); j--){
                    if(size-j>=0 && temp==list.get(j)){
                        flag=false;
                    }
                }
                if(flag){
                    list.add(temp);
                    needIdel = false;
                } else {
                    queue.offer(temp);
                }
            }
            if(needIdel)
                list.add(' ');
        }
        return list.size();
    }

    /*
    贪心算法：每次都从可执行任务中挑选剩余数量最多的执行，若都不可执行，加入idle空闲期
    Idea is to add them to a priority Q and sort based on the highest frequency.
    And pick the task in each round of ‘n’ with highest frequency. As you pick the task, decrease the frequency, and put them back after the round.
     */
    public int leastInterval2(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<tasks.length; i++){
            map.put(tasks[i], map.getOrDefault(tasks[i], 0)+1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (a, b)->a.getValue()!=b.getValue()?b.getValue()-a.getValue(): a.getKey()-b.getKey()
        );
        pq.addAll(map.entrySet());
        int count = 0;
        while (!pq.isEmpty()){
            int k = n+1;
            List<Map.Entry> tempList = new ArrayList<>();
            while (k > 0 && !pq.isEmpty()) {
                Map.Entry<Character, Integer> top = pq.poll(); // most frequency task
                top.setValue(top.getValue() - 1); // decrease frequency, meaning it got executed
                tempList.add(top); // collect task to add back to queue
                k--;
                count++; //successfully executed task
            }

            for (Map.Entry<Character, Integer> e : tempList) {
                if (e.getValue() > 0) pq.add(e); // add valid tasks
            }

            if (pq.isEmpty())
                break;

            count = count + k; //if k > 0, then it means we need to be idle
        }
        return count;
    }
}
