package java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by haileyyin on 4/22/18.
 */
public class TwoSumIII {
    private List<Integer> list = new ArrayList<Integer>();
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
        list.add(number);
    }

    public boolean find(int value) {
        for (int i = 0; i < list.size(); i++){
            int num1 = list.get(i);
            int num2 = value - num1;
            if ((num1 == num2 && map.get(num1) > 1) || (num1 != num2 && map.containsKey(num2)))
                return true;
        }
        return false;
    }
}
