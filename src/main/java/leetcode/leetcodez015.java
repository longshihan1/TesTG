package leetcode;

import java.util.Stack;

public class leetcodez015 {
    public static void main(String[] args) {
        SearchTree searchTree = new SearchTree();
        for (int i = 0; i < 4; i++) {
            searchTree.addTreeNode(i);
        }
    }

    /**
     * 功能概要：
     */
    public static class TreeNode {
        public Integer data;
        /*该节点的父节点*/
        public TreeNode parent;
        /*该节点的左子节点*/
        public TreeNode left;
        /*该节点的右子节点*/
        public TreeNode right;

        public TreeNode(Integer data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "TreeNode [data=" + data + "]";
        }
    }


    /**
     * 功能概要：排序/平衡二叉树
     */
    public static class SearchTree {
        public TreeNode root;
        public long size;

        /**
         * 往树中加节点
         *
         * @param data
         * @return Boolean 插入成功返回true
         */
        public Boolean addTreeNode(Integer data) {
            if (null == root) {
                root = new TreeNode(data);
                System.out.println("数据成功插入到平衡二叉树中");
                return true;
            }
            TreeNode treeNode = new TreeNode(data);// 即将被插入的数据
            TreeNode currentNode = root;
            TreeNode parentNode;
            while (true) {
                parentNode = currentNode;// 保存父节点
                // 插入的数据比父节点小
                if (currentNode.data > data) {
                    currentNode = currentNode.left;
                    // 当前父节点的左子节点为空
                    if (null == currentNode) {
                        parentNode.left = treeNode;
                        treeNode.parent = parentNode;
                        System.out.println("数据成功插入到二叉查找树中");
                        size++;
                        return true;
                    }// 插入的数据比父节点大
                } else if (currentNode.data < data) {
                    currentNode = currentNode.right;
                    // 当前父节点的右子节点为空
                    if (null == currentNode) {
                        parentNode.right = treeNode;
                        treeNode.parent = parentNode;
                        System.out.println("数据成功插入到二叉查找树中");
                        size++;
                        return true;
                    }
                } else {
                    System.out.println("输入数据与节点的数据相同");
                    return false;
                }
            }
        }

        /**
         * @param data
         * @return TreeNode
         */
        public TreeNode findTreeNode(Integer data) {
            if (null == root) {
                return null;
            }
            TreeNode current = root;
            while (current != null) {
                if (current.data > data) {
                    current = current.left;
                } else if (current.data < data) {
                    current = current.right;
                } else {
                    return current;
                }
            }
            return null;
        }

        /**
         * 递归实现中序遍历
         *
         * @param treeNode
         */
        public static void medOrderMethodOne(TreeNode treeNode) {
            if (null != treeNode) {
                if (null != treeNode.left) {
                    medOrderMethodOne(treeNode.left);
                }
                System.out.print(treeNode.data + " ");
                if (null != treeNode.right) {
                    medOrderMethodOne(treeNode.right);
                }
            }

        }
        public static void medOrderMethodTwo(TreeNode treeNode){
            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode current = treeNode;
            while (current != null || !stack.isEmpty()) {
                while(current != null) {
                    stack.push(current);
                    current = current.left;
                }
                if (!stack.isEmpty()) {
                    current = stack.pop();
                    System.out.print(current.data+" ");
                    current = current.right;
                }
            }
        }

    }
}
