package bst;

import binaryTree.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Collections;

public class PathInBst {

    public static ArrayList<Integer> findPath(BinaryTreeNode<Integer> root, int data) {
        ArrayList<Integer> list = getPath(root, data, new ArrayList<Integer>());
        Collections.reverse(list);
        return list;

    }

    private static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int data, ArrayList<Integer> list) {
        if (root == null)
            return null;
        if (root.data == data)
            return list;
        list.add(root.data);
        if (data > root.data)
            return getPath(root.right, data, list);
        return getPath(root.left, data, list);
    }
}
