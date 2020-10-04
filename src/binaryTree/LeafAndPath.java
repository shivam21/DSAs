package binaryTree;

import java.util.ArrayList;

public class LeafAndPath {

    public static void main(String[] args) {
        boolean result = leafandPath(BinaryTreeUse.takeInput());
        System.out.println(result);
    }

    static boolean leafandPath(BinaryTreeNode<Integer> root) {
        ArrayList<String> list = new ArrayList<>();
        String leaf = leafandPathHelper(root, list, "", "");
        return list.contains(leaf);
    }

    private static String leafandPathHelper(BinaryTreeNode<Integer> root, ArrayList<String> list, String path, String result) {
        if (root == null)
            return result;
        if (root.left == null && root.right == null) {
            path += root.data;
            list.add(path);
            result += root.data;
            return result;
        }
        String leftPath = leafandPathHelper(root.left, list, path + root.data, result);
        String rightPath = leafandPathHelper(root.right, list, path + root.data, result);
        return leftPath + rightPath;
    }
}
