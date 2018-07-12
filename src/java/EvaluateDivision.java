package java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by haileyyin on 7/6/18.
 */
public class EvaluateDivision {
    /*
    image a/b = k as a link between node a and node b, the weight from a to b is k, and the reverse is 1/k.
    Query is to find a path between two nodes.
     */
    HashMap<String, ArrayList<String>> pairs = new HashMap<>();
    HashMap<String, ArrayList<Double>> valuesPair = new HashMap<>();

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {

        for (int i = 0; i < equations.length; i++) {
            String[] equ = equations[i];
            if (!pairs.containsKey(equ[0])) {
                pairs.put(equ[0], new ArrayList<String>());
                valuesPair.put(equ[0], new ArrayList<Double>());
            }
            if (!pairs.containsKey(equ[1])) {
                pairs.put(equ[1], new ArrayList<String>());
                valuesPair.put(equ[1], new ArrayList<Double>());
            }
            pairs.get(equ[0]).add(equ[1]);
            pairs.get(equ[1]).add(equ[0]);
            valuesPair.get(equ[0]).add(values[i]);
            valuesPair.get(equ[1]).add(1/values[i]);
        }
        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String[] query = queries[i];
            res[i] = dfs(query[0], query[1], new HashSet<>(), 1);
            if (res[i] == 0.0) {
                res[i] = -1.0;
            }
        }
        return res;
    }

    private double dfs(String start, String end, HashSet<String> set, double value) {
        if (set.contains(start))
            return 0.0;
        if (!pairs.containsKey(start))
            return 0.0;
        if (start.equals(end))
            return value;

        set.add(start);
        ArrayList<String> strList = pairs.get(start);
        ArrayList<Double> valueList = valuesPair.get(start);
        double temp = 0;
        for (int i = 0; i < strList.size(); i++) {
            temp = dfs(strList.get(i), end, set, value*valueList.get(i));
            if (temp != 0.0) {
                break;
            }
        }
        set.remove(start);
        return temp;
    }
}
