package binaryTree;

import binaryTree.BinaryTreeNode;

import java.util.HashMap;

public class NodesSumS {
    public static void nodesSumToS(BinaryTreeNode<Integer> root, int sum) {
        HashMap<Integer, Boolean> map = getMap(root, new HashMap<>());
        printPairs(root, map, sum);
    }

    private static void printPairs(BinaryTreeNode<Integer> root, HashMap<Integer, Boolean> map, int sum) {
        if (root == null)
            return;
        int key = sum - root.data;
        if (map.containsKey(key) && map.get(key)) {
            map.put(key, false);
            map.put(root.data, false);
            System.out.println(Math.min(key, root.data) + " " + Math.max(key, root.data));
        }
        printPairs(root.left, map, sum);
        printPairs(root.right, map, sum);
    }

    private static HashMap<Integer, Boolean> getMap(BinaryTreeNode<Integer> root, HashMap<Integer, Boolean> map) {
        if (root == null) {
            return map;
        }
        map.put(root.data, true);
        HashMap<Integer, Boolean> map1 = getMap(root.left, map);
        HashMap<Integer, Boolean> map2 = getMap(root.right, map);
        map1.putAll(map2);
        return map1;
    }
}
