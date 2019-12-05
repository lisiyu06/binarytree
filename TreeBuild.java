package at1205;

import java.util.Scanner;

/**
 * Author: lisiyu
 * Created: 2019/12/5
 */
public class TreeBuild {
    static class TreeNode {
        public char val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.next();
            // line 就是一组先序遍历结果（带 #）
            TreeNode root = bulidTree(line);
            inOrder(root);
            System.out.println();
        }
    }

    static int index = 0;
    public static TreeNode bulidTree(String line) {
        // 记录当前递归过程中访问到字符串中的第几个字符了
        index= 0;
        return creatTreePreOrder(line);
    }

    // 这个辅助函数来完成递归
    public static TreeNode creatTreePreOrder(String line) {
        char c = line.charAt(index);
        if (c == '#') {
            return null;
        }
        TreeNode root = new TreeNode(c);
        index++;
        root.left = creatTreePreOrder(line);
        index++;
        root.right = creatTreePreOrder(line);
        return root;
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

}
