package leetcode;

import leetcode.node.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class leetcode297 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        String ee=serialize(node);
        deserialize(ee);
    }

    public static String serialize(TreeNode root) {
        StringBuilder string = new StringBuilder();
        Queue<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.poll();
            string.append(node.val);
            System.out.print(node.val);
            if (stack.size() == 2 && node.left == null && node.right == null) {
                string.append("##");
            }
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return string.toString();
    }

    public static TreeNode deserialize(String data) {
        String[] strings=data.split("");
        int n=data.length();
        TreeNode root=new TreeNode(Integer.parseInt(strings[0]));
        Queue<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        int index=(n-1)/2;
        for (int i = 0; i <n; i++) {
            if (i%2==0){
                int left=left(i);
                if (left>n){
                    break;
                }
                String leftStr=strings[left(i)];
                if (!leftStr.equals("#")){
                    root.left=new TreeNode(Integer.parseInt(leftStr));

                }
            }else {
                int right=right(i);
                if (right>n){
                    break;
                }
                String rightStr=strings[right];
                if (!rightStr.equals("#")){
                    root.right=new TreeNode(Integer.parseInt(rightStr));
                }
            }
        }
        return root;
    }

    public static int left(int index){
        return ((index+1)>>1);
    }

    public static int right(int index){
        return ((index+1)>>1)+1;
    }
}
