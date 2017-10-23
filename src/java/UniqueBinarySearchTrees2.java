package java;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by haileyyin on 10/22/17.
 */
public class UniqueBinarySearchTrees2 {
    /*
    每个节点作为根结点，递归构造其左边的数字可能组成的二叉树，和右边数字可能组成的二叉树。
    这个方法有个缺点，其实我们都知道，相同数量的节点能构造出的二叉树数量是一样的，
    但这个方法我们冗余计算了很多次相同节点数的二叉树数量，所以我们可以建立一个数组来记录各个数量的节点可能构造的二叉树数量，
    再根据位移量得出当前位置这个数量的节点所构成的二叉树。
     */
    public List<TreeNode> generateTrees(int n) {
        if(n<=0) return new LinkedList<>();
        return generateChildrenTrees(n, 1);
    }

    public List<TreeNode> generateChildrenTrees(int n, int rootVal){
        List<TreeNode> list = new LinkedList<>();
        if(n==1) {
            list.add(new TreeNode(rootVal));
            return list;
        }
        for(int i=0; i<n; i++){
            List<TreeNode> temp = new LinkedList<>();
            List<TreeNode> leftTrees = new LinkedList<>();
            List<TreeNode> rightTrees = new LinkedList<>();
            if(i>0){
                leftTrees = generateChildrenTrees(i, rootVal);
            }
            if(i<n-1){
                rightTrees = generateChildrenTrees(n-i-1, rootVal+i+1);
            }
            if(leftTrees.size()>0 && rightTrees.size()>0){
                for(int j=0; j<leftTrees.size(); j++) {
                    for(int k=0; k<rightTrees.size(); k++) {
                        TreeNode root = new TreeNode(rootVal+i);
                        root.left=leftTrees.get(j);
                        root.right=rightTrees.get(k);
                        temp.add(root);
                    }
                }
            }else if(leftTrees.size()>0 && rightTrees.size()==0){
                for(int j=0; j<leftTrees.size(); j++){
                    TreeNode root = new TreeNode(rootVal+i);
                    root.left=leftTrees.get(j);
                    temp.add(root);
                }
            }else if(leftTrees.size()==0 && rightTrees.size()>0){
                for(int j=0; j<rightTrees.size(); j++){
                    TreeNode root = new TreeNode(rootVal+i);
                    root.right=rightTrees.get(j);
                    temp.add(root);
                }
            }
            list.addAll(temp);
        }
        return list;
    }
}
