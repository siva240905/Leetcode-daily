class Solution {

    // Stores the number of nodes whose subtree
    // average is equal to the node's value.
    int res = 0;

    public int averageOfSubtree(TreeNode root) {

        // Process the tree using postorder traversal
        postOrder(root);

        return res;
    }

    // Returns:
    // result[0] = sum of the subtree
    // result[1] = number of nodes in the subtree
    public int[] postOrder(TreeNode node) {

        // Empty subtree has sum 0 and count 0
        if (node == null) {
            return new int[]{0, 0};
        }

        // Get sum and count from the left subtree
        int[] left = postOrder(node.left);

        // Get sum and count from the right subtree
        int[] right = postOrder(node.right);

        // Calculate sum of the current subtree
        int sum = left[0] + right[0] + node.val;

        // Calculate number of nodes in the current subtree
        int count = left[1] + right[1] + 1;

        // Check whether the average of the subtree
        // is equal to the current node's value.
        if (sum / count == node.val) {
            res++;
        }

        // Return information about the current subtree
        return new int[]{sum, count};
    }
}