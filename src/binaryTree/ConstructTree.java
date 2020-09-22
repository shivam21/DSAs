package binaryTree;

public class ConstructTree {

    public static BinaryTreeNode<Integer> getTreeFromPostorderAndInorder(int[] post,
                                                                         int[] in) {

        return getTreeFromPostorderAndInorder(post, in, 0, post.length - 1, 0, in.length - 1);

    }

    private static BinaryTreeNode<Integer> getTreeFromPostorderAndInorder(int[] post, int[] in, int postStart, int postEnd, int inStart, int inEnd) {
        if (postEnd > postStart || inEnd > inStart)
            return null;
        int rootData = post[postEnd];
        int inOrderRootIndex = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (rootData == in[i]) {
                inOrderRootIndex = i;
                break;
            }
        }
        if (inOrderRootIndex == -1)
            return null;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        int leftLength = inOrderRootIndex - inStart;
        root.left = getTreeFromPostorderAndInorder(post, in, postStart, postStart + leftLength - 1, inStart, inOrderRootIndex - 1);
        root.right = getTreeFromPostorderAndInorder(post, in, postStart + leftLength, postEnd - 1, inOrderRootIndex + 1, inEnd);
        return root;
    }
}
