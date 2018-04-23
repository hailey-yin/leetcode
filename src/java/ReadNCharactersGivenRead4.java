package java;

/**
 * Created by haileyyin on 4/19/18.
 */
public class ReadNCharactersGivenRead4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    /*
    Time: O(n)
    Space: O(1)
    */
    public int read(char[] buf, int n) {
        char[] temp = new char[4];
        int index = 0;
        while (true) {
            int count = read4(temp);
            count = Math.min(count, n-index);
            for (int i=0; i<count; i++) {
                buf[index++] = temp[i];
            }
            if (index==n||count<4)
                return index;
        }
    }

    /*
    provided by leetcode
     */
    private int read4(char[] temp){
        return 0;
    }
}
