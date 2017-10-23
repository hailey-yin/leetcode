package java;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by haileyyin on 10/22/17.
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
    /*
    本题在属于二叉树遍历的经典题目，已知二叉树的两个遍历序列构造二叉树，有如下性质：
    -若已知先序和中序，则可以构造出唯一的二叉树
    -若已知先序和后序，则可以构造出多颗不同的二叉树
    -若已知中序和后序，则可以构造出唯一的二叉树

    可以肯定postorder的最后一个数一定是root，然后在inorder中找到p的位置，我们可以找到根结点两颗子树对应的inorder和postorder：

    左子树的inorder = inorder[0…p-1]
    右子树的inorder = inorder[p+1…n-1] 【p是根结点位置】
    左子树的postorder = postorder[0…p-1]
    右子树的postorder = postorder[p…n-2] 【n-1是根结点位置】

    递归处理左右子树，知道inorder和postorder长度都为1，就找到了叶子结点，开始回溯。

    update：用哈希表存储中序队列，可以快速找到某个元素的位置
     */

    //方法一：
    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        return buildingTree(0, inorder.length-1, 0, postorder.length-1, inorder, postorder);
    }

    public TreeNode buildingTree(int leftIn, int rightIn, int leftPo, int rightPo, int[] inorder, int[] postorder){
        if(leftIn>rightIn){
            return null;
        }
        TreeNode t = new TreeNode(postorder[rightPo]);

        int d = 0;
        for(int i=0; i<rightIn-leftIn+1; i++){
            if(inorder[leftIn+i]==t.val){
                d = i;
                break;
            }
        }
        //left child tree
        t.left = buildingTree(leftIn,leftIn+d-1,leftPo, leftPo+d-1, inorder, postorder);
        //right child tree
        t.right = buildingTree(leftIn+d+1, rightIn, leftPo+d, rightPo-1, inorder, postorder);
        return t;
    }

    //方法二：

    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        Map<Integer, Integer> hmap = new HashMap();
        for(int i = 0; i < inorder.length; i++)
            hmap.put(inorder[i], i);
        return buildingTree(0, inorder.length-1, 0, postorder.length-1, inorder, postorder,hmap);
    }

    public TreeNode buildingTree(int leftIn, int rightIn, int leftPo, int rightPo, int[] inorder, int[] postorder, Map<Integer, Integer> hmap){
        if(leftIn>rightIn){
            return null;
        }
        TreeNode t = new TreeNode(postorder[rightPo]);

        int ri = hmap.get(postorder[rightPo]);

        //left child tree
        t.left = buildingTree(leftIn,ri-1,leftPo, leftPo+(ri-leftIn)-1, inorder, postorder, hmap);
        //right child tree
        t.right = buildingTree(ri+1, rightIn, leftPo+(ri-leftIn), rightPo-1, inorder, postorder,hmap);
        return t;
    }
}

