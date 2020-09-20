package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode114 {
    public static void main(String[] args) {
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(2);
        node.right=new TreeNode(5);
        node.left.left=new TreeNode(3);
        node.left.right=new TreeNode(4);
        node.right.right=new TreeNode(6);
        flatten(node);
    }

    public static void flatten(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;
        //如果右子树为空左子树不为空
        if (root.left != null && root.right == null) {
            root.right = root.left;
            root.left = null;
        }
        //如果右子树不为空左子树为空对右子树进行递归
        if (root.left == null && root.right != null) {
            flatten(root.right);
            return;
        }
        //如果左右子树都不为空左右子树分别递归 递归完把左子树加进到右子树中
        if (root.left != null && root.right != null) {
            flatten(root.left);
            flatten(root.right);
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.right = left;
            while (left.right != null) {
                left = left.right;
            }
            left.right = right;
            root.left = null;
        }
    }

    public static class TreeNode {
        public int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

       public TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
