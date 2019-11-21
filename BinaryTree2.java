package homework20;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: lisiyu
 * Created: 2019/11/21
 */

public class BinaryTree2 {

    // 内部类
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // 二叉树的前序遍历 ----- 力扣144
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 访问根节点，此处指的是把当前节点的值 插入到 result 中
        result.add(root.val);
        // 递归遍历左子树
        result.addAll(preorderTraversal(root.left));
        // 递归遍历右子树
        result.addAll(preorderTraversal(root.right));
        return result;
    }

    // 二叉树的中序遍历 ------ 力扣94
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result;
    }

    // 二叉树的后序遍历 ----- 力扣145
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.right));
        result.add(root.val);
        return result;
    }



}
