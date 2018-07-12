package java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haileyyin on 6/27/18.
 */
public class ZigzagIterator {
    List<List<Integer>> list;
    int row;
    int col;
    int maximumCol;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list = new ArrayList<>();
        list.add(v1);
        list.add(v2);
        row = 0;
        col = 0;
        maximumCol = Math.max(v1.size(), v2.size());
    }

    public int next() {
        return list.get(row++).get(col);
    }

    public boolean hasNext() {
        while (col < maximumCol) {
            if (row >= list.size()) {
                row = 0;
                col++;
            }
            if (list.get(row).size() > col) {
                return true;
            } else {
                row++;
            }
        }
        return false;
    }
}
