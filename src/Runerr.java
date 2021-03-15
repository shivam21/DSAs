import binaryTree.BinaryTreeNode;
import linkedlists.LinkedListNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Runerr {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static BinaryTreeNode<Integer> takeInput() throws NumberFormatException, IOException {
        Queue<BinaryTreeNode<Integer>>  pendingNodes = new LinkedList<>();
        int start = 0;

        String[] nodeDatas = br.readLine().trim().split(" ");

        int rootData = Integer.parseInt(nodeDatas[start]);
        start += 1;

        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        pendingNodes.add(root);

        while(!pendingNodes.isEmpty()){
            BinaryTreeNode<Integer> currentNode;
            try {
                currentNode = pendingNodes.remove();
            } catch (Exception e) {
                return null;
            }

            int leftChildData = Integer.parseInt(nodeDatas[start]);
            start += 1;

            if(leftChildData != -1){
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
                currentNode.left = leftChild;
                pendingNodes.add(leftChild);
            }

            int rightChildData = Integer.parseInt(nodeDatas[start]);
            start += 1;

            if(rightChildData != -1){
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
                currentNode.right = rightChild;
                pendingNodes.add(rightChild);
            }
        }

        return root;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BinaryTreeNode<Integer> root = takeInput();
        Solution.inOrder(root);
    }
}
