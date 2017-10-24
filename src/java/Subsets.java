package java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by haileyyin on 10/22/17.
 */
public class Subsets {
    /*
    位运算：
    假设nums有n位数，那么可以组成的子集数量等于n位bit可以表示多少个数，即2^n。
    如何把这2^n个数的二进制码列出来？
    已知这些数的十进制是从0到2^n，通过右移和&1对每个数的每一个二进制位进行判断。
    如何遍历List<List<Integer>>的同时删除和更新数据？
    iterator可以在遍历是删除，但不支持更新。
    For循环可以在遍历时删除，也可以在遍历时更新，但同时进行index会混乱。
    解决办法：使用for循环，每次建立一个新的list，把需要更新的内容添加进去，不更新的（需要删除）的内容不进行添加。最后原list清空，把新list的内容全部添加。
     */
    public List<List<Integer>> subsets1(int[] nums) {
        int w = (int)Math.pow(2, nums.length);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<w; i++){
            List<Integer> num = new ArrayList<>();
            for(int j=0; j<nums.length; j++){
                int bit = (((i>>j)&1)==1)? 1:0;
                num.add(bit);
            }
            res.add(num);
        }
        for(List<Integer> item:res){
            List<Integer> num = new ArrayList<>();
            for(int i=0; i<nums.length; i++){
                if(item.get(i)==1){
                    num.add(nums[i]);
                }
            }
            item.clear();
            item.addAll(num);
        }
        return res;
    }
    /*
    update:两个for循环可以合并的嘛
     */
    public List<List<Integer>> subsets2(int[] nums) {
        int w = (int)Math.pow(2, nums.length);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<w; i++){
            List<Integer> num = new ArrayList<>();
            for(int j=0; j<nums.length; j++){
                int bit = (((i>>j)&1)==1)? 1:0;
                if(bit==1)
                    num.add(nums[j]);
            }
            res.add(num);
        }
        return res;
    }
    /*
    backtracking函数通过start变量来避免相同子集的出现public List<List<Integer>> subsetsWithDup(int[] nums) {

    }
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans  = new LinkedList<>();
        Arrays.sort(nums);
        backtracking(new ArrayList<>(), nums, ans, 0);
        return ans;
    }

    private void backtracking(List<Integer> curr, int[] nums, List<List<Integer>> ans, int start){
        ans.add(new ArrayList<>(curr));
        for(int i=start; i<nums.length; i++){
            curr.add(nums[i]);
            backtracking(curr, nums, ans, i+1);
            curr.remove(curr.size()-1);
        }
    }
}
