class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class recover_the_bst {
    TreeNode firstIncorrectNode = null;
    TreeNode secondIncorrectNode = null;
    TreeNode prevNode = null;

    public void recoverTree(TreeNode root) {
        TreeNode current = root;
        TreeNode temp;
        while (current != null) {
            if (current.left == null) {
                // Process current node
                if (prevNode != null &&
                        prevNode.val >= current.val) {
                    if (firstIncorrectNode == null) {

                        firstIncorrectNode = prevNode;
                    }
                    secondIncorrectNode = current;
                }
                prevNode = current;
                current = current.right;
            } else {
                // Find the inorderpredecessor
                temp = current.left;
                while (temp.right != null && temp.right != current) {
                    temp = temp.right;
                }
                if (temp.right == null) {
                    // Set the right pointer to enable returning to the current node
                    temp.right = current;
                    current = current.left;
                } else {
                    // Restore the right pointer and process current node
                    temp.right = null;
                    if (prevNode != null && prevNode.val >= current.val) {
                        if (firstIncorrectNode == null) {

                            firstIncorrectNode = prevNode;
                        }

                        secondIncorrectNode = current;
                    }
                    prevNode = current;
                    current = current.right;
                }
            }
        }
        // Swap the values of the two incorrectly placed nodes
        int tempVal = firstIncorrectNode.val;
        firstIncorrectNode.val = secondIncorrectNode.val;
        secondIncorrectNode.val = tempVal;
    }

    public static void main(String[] args) {
        // Create a sample binary search tree with 5 numbers (incorrect order)
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        recover_the_bst solution = new recover_the_bst();
        solution.recoverTree(root);
        // Print the inorder traversal of the recovered BST
        System.out.println("Inorder Traversal of Recovered BST:");
        printInorder(root);
    }

    // Helper function to print the inorder traversal of a tree
    private static void printInorder(TreeNode node) {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }
}
