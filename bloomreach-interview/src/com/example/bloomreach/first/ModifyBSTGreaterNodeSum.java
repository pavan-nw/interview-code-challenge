package com.example.bloomreach.first;

public class ModifyBSTGreaterNodeSum {
    public  int value;
    public ModifyBSTGreaterNodeSum left;
    public ModifyBSTGreaterNodeSum right;

    public ModifyBSTGreaterNodeSum(int i) {
        value = i;
    }

    public static void main(String[] args) {
    // Q:
    //
    //  Given the root of a BST where each node has some value (node.value).
    //  Convert the value of each node(N) to the sum of all node values greater than N.
    //  value in the bst and the original N.value.
    //
    //        Ex:
    //
    //           8
    //        /    \
    //       3      12
    //    /   \      /
    //  1      6      10
    //   \    / \
    //    2  5   7

    //          30
    //         /    \
    //      51       12
    //     /   \       /
    //  54     43     22
    //    \    /  \
    //    53   48  37
        System.out.println("Running main");
        ModifyBSTGreaterNodeSum root = new ModifyBSTGreaterNodeSum(8);
        root.left = new ModifyBSTGreaterNodeSum(3);
        root.left.left = new ModifyBSTGreaterNodeSum(1);
        root.left.right = new ModifyBSTGreaterNodeSum(6);
        root.left.right.left = new ModifyBSTGreaterNodeSum(5);
        root.left.right.right = new ModifyBSTGreaterNodeSum(7);
        root.left.left.right = new ModifyBSTGreaterNodeSum(2);
        root.right = new ModifyBSTGreaterNodeSum(12);
        root.right.left = new ModifyBSTGreaterNodeSum(10);
        updateNodeWithSum(root, 0);
        dfs(root);
    }

    private static void dfs(ModifyBSTGreaterNodeSum root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        dfs(root.left);
        dfs(root.right);
    }

    private static int updateNodeWithSum(ModifyBSTGreaterNodeSum root, int sum) {
        if (root == null) {
            return sum;
        }
        sum = updateNodeWithSum(root.right, sum);

        sum = sum + root.value;
        root.value = sum;

        sum = updateNodeWithSum(root.left, sum);
        return sum;
    }
}
