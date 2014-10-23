/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class ValidateBST {

    static int pre = Integer.MAX_VALUE;

    public static boolean isValidBST1(TreeNode root) {
        if(root == null) return true;

        boolean isLeftValid = isValidBST1(root.left);

        if(pre != Integer.MAX_VALUE && root.val <= pre) return false;

        pre = root.val;

        return isLeftValid && isValidBST1(root.right);
    }

    public static boolean isValidBST2(TreeNode root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean helper(TreeNode root, int min, int max) {
        if(root == null) return true;

        if(root.val <= min || root.val >= max) return false;

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

    public static void main(String[] args) {
//            1
//           / \
//          2  3
//            /
//           4
//           \
//           5
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(4);
//        root.right.left.right = new TreeNode(5);

//            3
//           / \
//          2  5
//         / \
//        1  4
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(5);
//        root.left.left = new TreeNode(1);
//        root.left.left.right = new TreeNode(4);

        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(-1);

        boolean result = isValidBST1(root);
        System.out.println(result);

    }
}
