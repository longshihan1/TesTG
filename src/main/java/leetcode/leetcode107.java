package leetcode;

import java.util.*;

public class leetcode107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> allList=new LinkedList<>();
        if (root == null) {
            return allList;
        }
        Queue<TreeNode> stack=new LinkedList<>();
        stack.offer(root);
        while (!stack.isEmpty()){
            int size=stack.size();
            List<Integer> list=new ArrayList<>();
            for (int i = 0; i <size; i++) {
                TreeNode treeNode=stack.poll();
                list.add(treeNode.val);
                if (treeNode.left!=null){
                    stack.offer(treeNode.left);
                }
                if (treeNode.right!=null){
                    stack.offer(treeNode.right);
                }
            }
            allList.add(0,list);
        }
        return allList;
    }
    public static class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;
        public TreeNode(int x) {
            val = x;
        }
    }
}
