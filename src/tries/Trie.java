package tries;

import java.util.ArrayList;

class TrieNode {
    char data;
    boolean isTerminating;
    TrieNode[] children;
    int childCount = 0;

    public TrieNode(char data) {
        this.data = data;
        children = new TrieNode[26];
    }
}

public class Trie {

    private TrieNode root;
    private int numWords;

    public Trie() {
        root = new TrieNode('\0');
        numWords = 0;
    }

    public boolean search(String word) {
        return search(root, word);
    }

    private boolean search(TrieNode root, String word) {
        if (word.length() == 0) {
            return root.isTerminating;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            return false;
        }
        return search(child, word.substring(1));
    }


    public void remove(String word) {
        if (remove(root, word)) {
            numWords--;
        }
    }


    private boolean remove(TrieNode root, String word) {
        if (word.length() == 0) {
            if (root.isTerminating) {
                root.isTerminating = false;
                return true;
            } else {
                return false;
            }
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            return false;
        }
        boolean ans = remove(child, word.substring(1));
        // We can remove child node only if it is non terminating and its number of children are 0

        if (!child.isTerminating && child.childCount == 0) {
            root.children[childIndex] = null;
            child = null;
            root.childCount--;
        }
        return ans;
    }

    private boolean add(TrieNode root, String word) {
        if (word.length() == 0) {
            if (root.isTerminating) {
                return false;
            } else {
                root.isTerminating = true;
                return true;
            }
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
            root.childCount++;
        }
        return add(child, word.substring(1));
    }

    public void add(String word) {
        if (add(root, word)) {
            numWords++;
        }
    }

    public int countWords() {
        return numWords;

    }

    public boolean patternMatching(ArrayList<String> input, String pattern) {
        for (int i = 0; i < input.size(); i++) {
            String word = input.get(i);
            for (int j = 0; j < word.length(); j++) {
                add(word.substring(i));
            }
        }
        return search(pattern);
    }

    public void autoComplete(ArrayList<String> input, String word) {
        for (String s : input) {
            add(s);
        }
        printWords(root, word, "");
    }

    private void printWords(TrieNode root, String word, String output) {
        if (word.isEmpty() && root.isTerminating)
            System.out.println(output);
        TrieNode[] children = root.children;
        if (word.isEmpty()) {
            for (int i = 0; i < children.length; i++) {
                if (children[i] != null)
                    printWords(root.children[i], word, output + children[i].data);

            }
        } else {
            char c = word.charAt(0);
            for (int i = 0; i < children.length; i++) {
                if (children[i] != null && children[i].data == c)
                    printWords(root.children[i], word.substring(1), output + c);
            }
        }
    }

    public boolean isPalindromePair(ArrayList<String> words) {
        for (String word : words) {
            add(word);
            add(word.substring(1));
            if (isFound(root, word)||isFound(root, word.substring(1)))
                return true;
        }
        return false;
    }

    private boolean isFound(TrieNode root, String word) {
        if (word.length() == 0) {
            return root.isTerminating;
        }

        int lastIndex = word.length() - 1;
        int childIndex = word.charAt(lastIndex) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            return false;
        }

        return isFound(child, word.substring(0, lastIndex));
    }


}
