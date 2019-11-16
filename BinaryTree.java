package homework20;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * Author: lisiyu
 * Created: 2019/11/15
 */

// 二叉树

class Node {
    public char val;
    public Node left;
    public Node right;

    public Node(char val) {
        this.val = val;
    }
}

public class BinaryTree {
    // 根节点，当 root 为 null 时，就是一个空树
    private static Node root = null;

    // 构建一棵树，构成一个固定的树
    public static Node build() {
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.left = G;
        C.right = F;
        return A;
    }

    // 先序遍历
    public static void prevOrder(Node root) {
        // 先访问根节点，递归遍历左子树，递归遍历右子树
        if (root == null) {
            // 空树不需要遍历
            return;
        }
        // 访问就用 打印 来表示
        System.out.print(root.val);
        prevOrder(root.left);
        prevOrder(root.right);
    }

    // 中序遍历
    public static void inOrder(Node root) {
        // 先遍历左子树，再访问根节点，再遍历右子树
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val);
        inOrder(root.right);
    }

    // 后序遍历
    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val);
    }

    public static void main(String[] args) {
        root = build();
        prevOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
    }

}
