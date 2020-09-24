package bst;

import binaryTree.BinaryTreeNode;
import binaryTree.Pair;
import linkedlists.LinkedListNode;

public class BstToSortedLL {
    public static LinkedListNode<Integer> BSTToSortedLL(BinaryTreeNode<Integer> root) {
        return getSortedLL(root).first;
    }

    private static Pair<LinkedListNode<Integer>, LinkedListNode<Integer>> getSortedLL(BinaryTreeNode<Integer> root) {
        if (root == null)
            return new Pair<>(null, null);
        Pair<LinkedListNode<Integer>, LinkedListNode<Integer>> leftSubTree = getSortedLL(root.left);
        Pair<LinkedListNode<Integer>, LinkedListNode<Integer>> rightSubTree = getSortedLL(root.right);
        LinkedListNode<Integer> headTop = null, tail = null;
        if (leftSubTree.first != null) {
            headTop = leftSubTree.first;
            tail = leftSubTree.second;
        }
        LinkedListNode<Integer> node = new LinkedListNode<>(root.data);
        if (tail != null) {
            tail.next = node;
            tail=tail.next;
        } else {
            headTop = node;
            tail = node;
        }
        tail.next = rightSubTree.first;
        if (rightSubTree.second!=null){
            tail= rightSubTree.second;
        }else{
            tail=node;
        }
        return new Pair<>(headTop, tail);
    }
}
