package java;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by haileyyin on 10/22/17.
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
    //注意：preorder的根结点附近的点的坐标需要位移
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> hmap = new HashMap();
        for(int i = 0; i < inorder.length; i++)
            hmap.put(inorder[i], i);
        return buildingTree(0, preorder.length-1, 0, inorder.length-1, preorder, inorder, hmap);
    }

    public TreeNode buildingTree(int lp, int rp, int li, int ri, int[] preorder, int[] inorder, Map<Integer, Integer> hmap){
        if(li>ri){
            return null;
        }
        TreeNode t = new TreeNode(preorder[lp]);

        int d = hmap.get(preorder[lp]);

        //left child tree
        t.left = buildingTree(lp+1, lp+(d-li), li,d-1, preorder, inorder, hmap);
        //right child tree
        t.right = buildingTree(lp+(d-li)+1, rp,d+1, ri, preorder, inorder, hmap);
        return t;
    }
}
