package java;

/**
 * Created by haileyyin on 2/7/18.
 */
public class NumberComplement {
    /*for example:

      100110, its complement is 011001, the sum is 111111. So we only need get the min number large or equal to num, then do substraction

     */
    public int findComplement(int num)
    {
        int i = 0;
        int j = 0;

        while (i < num)
        {
            i += Math.pow(2, j);
            j++;
        }

        return i - num;
    }

    public int findComplement2(int num) {
        int copy = num, i=0;
        while (copy != 0) {
            copy >>= 1;
            num ^= (1<<i++);
        }
        return num;
    }
}
