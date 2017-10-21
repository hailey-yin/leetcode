package java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by haileyyin on 10/21/17.
 */
public class MaximumXORofTwoNumbersinanArray {

    /*
    方法一：divide&conquer

    对于输入的数组，我们将其中的元素根据最高位的值分为两类，最高位为0的一类，和最高位为1的一类，如果两类都不为空，那么问题的最终结果一定是从第一类中找一个数和从第二类中的一个数进行异或。
    那么这个问题可以优化为，从两个数列中各取一个数，求异或最大值。因此我们可以设计一个helper函数来帮助我们递归求解。

    假设我们根据当前最高位分为了arr0，arr1两类，我们可以继续根据下一个最高位对两类继续拆分得到
    arr0:arr00,arr01,
    arr1:arr10,arr11.
    那么解一定是在(arr00,arr11)和(arr01,arr10)中。
    如果两个配对中都出现空集，那么解一定是在(arr00,arr10)和(arr01,arr11)中

    O(n) = 2O(n/2)+n
    */
    public int findMaximumXOR1(int[] nums) {
        return helper(nums, null, 31);
    }

    private int helper(int[] nums1, int[] nums2, int index){
        //五种情况
        if(nums1==null && nums2==null)
            return 0;
        if(nums1==null){
            if(index<0)
                return 0;
            int[][] subNum = partition(nums2,index);
            return helper(subNum[0],subNum[1],index-1);
        }
        if(nums2==null){
            if(index<0)
                return 0;
            int[][] subNum = partition(nums1,index);
            return helper(subNum[0],subNum[1],index-1);
        }
        if(index<0)
            return nums1[0]^nums2[0];

        int[][] subNum1 = partition(nums1,index);
        int[][] subNum2 = partition(nums2,index);

        if((subNum1[0]!=null&&subNum2[1]!=null)||(subNum1[1]!=null&&subNum2[0]!=null)){
            return Math.max(helper(subNum1[0], subNum2[1], index-1),helper(subNum1[1], subNum2[0], index-1));
        } else {
            return Math.max(helper(subNum1[0], subNum2[0], index-1),helper(subNum1[1], subNum2[1], index-1));
        }

    }

    private int[][] partition(int[] num, int index){
        int mask =  (1<<index);
        List<Integer> temp1 = new ArrayList<>();
        List<Integer> temp2 = new ArrayList<>();
        for(int i=0; i<num.length; i++){
            if((num[i]&mask)==0){
                temp1.add(num[i]);
            } else {
                temp2.add(num[i]);
            }
        }
        int[] num1 = null;
        int[] num2 = null;
        if(temp1.size()!=0){
            num1 = new int[temp1.size()];
            for(int i=0; i<temp1.size(); i++){
                num1[i] = temp1.get(i);
            }
            temp1.clear();
        }
        if(temp2.size()!=0) {
            num2 = new int[temp2.size()];
            for(int i=0; i<temp2.size(); i++){
                num2[i] = temp2.get(i);
            }
            temp2.clear();
        }

        return new int[][] {num1,num2};
    }

    /*
    方法二：mask

    从最高位往低位一层一层计算出最大xor。
    mask从integer的最高位开始设置为1，然后与nums中各个数分别取交集，将结果保存到set中，目的是为了保存所有数的最高位。然后我们先假设这个位置在maximum xor结果中为1，然后带入这个假设的xor到set中，对每个数m，在set中是否存在数n使得满足xor^m=n（这里利用了一个异或运算的原理如果a^b=c, 那么a^c=b）。如果存在，那么xor结果中这一位肯定为1，否则为0.
    因为是从高位开始，每往低位走一步，max中都记录着之前所有高位的xor结果。不可以从低位往高位走，反例：
       00
     1001
      101
       11
    低位开始的前两位得出的max是11，但在实际的max后两位是01。因为对value真正起作用的是高位。
    */
    public int findMaximumXOR2(int[] nums){
        int max = 0;
        int mask = 0;
        for(int i=31; i>=0; i--){
            mask |= 1<<i;
            Set<Integer> set = new HashSet<>();
            for(int num:nums){
                set.add(num&mask);
            }
            int temp = max | (1<<i);
            for(int prefix:set){
                if(set.contains(prefix^temp)){
                    max = temp;
                    break;
                }
            }
        }
        return max;
    }

}
