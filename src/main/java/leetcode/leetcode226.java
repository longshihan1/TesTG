package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode226 {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(4);
        root.left=new TreeNode(2);
        root.right=new TreeNode(7);
        root.left.left=new TreeNode(1);
        root.left.right=new TreeNode(3);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(9);
        invertTree(root);

    }
    public static TreeNode invertTree(TreeNode root) {
        if (root==null){
            return null;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode=queue.poll();
                 TreeNode left=treeNode.left;
                 treeNode.left=treeNode.right;
                 treeNode.right=left;
                if (treeNode.left!=null){
                    queue.add(treeNode.left);
                }
                if (treeNode.right!=null){
                    queue.add(treeNode.right);
                }
            }
        }
        return root;
    }
}
