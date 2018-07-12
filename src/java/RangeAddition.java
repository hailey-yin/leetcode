package java;

/**
 * Created by haileyyin on 7/10/18.
 */
public class RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            int value = 0;
            for (int j = 0; j < updates.length; j++) {
                if (i >= updates[j][0] && i <= updates[j][1]) {
                    value += updates[j][2];
                }
            }
            res[i] = value;
        }
        return res;
    }
}
