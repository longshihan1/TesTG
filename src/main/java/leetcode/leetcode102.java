package leetcode;

import leetcode.node.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode102 {
    public static void main(String[] args) {
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(2);
        node.right=new TreeNode(3);
        node.left.left=new TreeNode(4);
        node.left.right=new TreeNode(5);

        List<List<Integer>> res=levelOrder(node);
        System.out.println("  ");
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if (root==null){
            return res;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        List<Integer> dd1=new ArrayList<>();
        dd1.add(root.val);
        res.add(dd1);
        while (!queue.isEmpty()){
            List<Integer> dd=new ArrayList<>();
            int size=queue.size();
            for (int i = 0; i <size; i++) {
                TreeNode node=queue.poll();
                if (node.left!=null) {
                    queue.add(node.left);
                    dd.add(node.left.val);
                }
                if (node.right!=null) {
                    queue.add(node.right);
                    dd.add(node.right.val);
                }
            }
            if (dd.size()>0) {
                res.add(dd);
            }
        }
        return res;
    }
}
