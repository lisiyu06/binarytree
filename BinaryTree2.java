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

    // 求结点个数
    public static int size(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }

    // 求叶子结点个数
    public static int leafSize(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return leafSize(root.left) + leafSize(root.right);
    }

    // 求第 K 层级结点个数
    public static int kLevelSize(TreeNode root, int k) {
        if (root == null || k < 1) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return kLevelSize(root.left, k - 1) + kLevelSize(root.right, k - 1);
    }

    public static TreeNode build() {
        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(3);
        TreeNode D = new TreeNode(4);
        TreeNode E = new TreeNode(5);
        TreeNode F = new TreeNode(6);
        TreeNode G = new TreeNode(7);
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.left = G;
        C.right = F;
        return A;
    }

    public static void main(String[] args) {
        TreeNode root = build();
        BinaryTree2 tree2 = new BinaryTree2();
        System.out.println(tree2.preorderTraversal(root));
        System.out.println(tree2.inorderTraversal(root));
        System.out.println(tree2.postorderTraversal(root));
        System.out.println(size(root));
        System.out.println(kLevelSize(root, 4));
    }



}
