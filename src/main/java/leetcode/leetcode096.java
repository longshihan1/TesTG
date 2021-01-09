package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode096 {
    public static void main(String[] args) {
        TreeNode node=new TreeNode(1);
        node.right=new TreeNode(2);
        node.right.left=new TreeNode(3);
         System.out.println(""+inorderTraversal(node));
    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        inorderTraversal(root,res);
        return res;
    }
    public static void inorderTraversal(TreeNode root, List<Integer> res) {
        if (root==null){
            return;
        }
        if (root.left != null) {
            inorderTraversal(root.left, res);
        }
        res.add(root.val);
        if (root.right != null) {
            inorderTraversal(root.right, res);
        }
    }


}
