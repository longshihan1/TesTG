package leetcode;

import leetcode.node.TreeNode;

import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leetcode094 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(3);
        List<Integer> list = inorderTraversal(node);
        System.out.println("  " + list);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        stack(root, res);
        return res;
    }

    public static void compin(TreeNode root, List<Integer> res) {
        if (root==null){
            return;
        }
        compin(root.left, res);
        res.add(root.val);
        compin(root.right, res);


    }

    public static void stack(TreeNode root, List<Integer> res) {
        Stack<TreeNode> stack = new Stack<>();
        while (root!=null||!stack.empty()) {
            while (root!=null){
                stack.push(root);
                root= root.left;
            }
            if (!stack.empty()){
                root=stack.pop();
                res.add(root.val);
                root=root.right;
            }
        }
    }

}
