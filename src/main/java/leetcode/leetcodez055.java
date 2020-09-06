package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class leetcodez055 {

    public static void main(String[] args) {


    }

    public static int maxDepth(TreeNode root){
        Queue<TreeNode> treeNodes=new LinkedList<>();
        int length=0;
        if (root!=null) {
            treeNodes.add(root);
        }
        while (!treeNodes.isEmpty()){
            length++;
            int size=treeNodes.size();
            for (int i = 0; i <size; i++) {
                TreeNode treeNode= treeNodes.poll();
                if (treeNode.left!=null){
                    treeNodes.add(treeNode.left);
                }
                if (treeNode.right!=null){
                    treeNodes.add(treeNode.right);
                }
            }
        }
        return length;
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
