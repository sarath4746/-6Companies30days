/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxSum = 0;

    class NodePair {
        int min, max, sum;
    }

    public NodePair getSum(TreeNode node) {
        if (node == null) {
            NodePair pair = new NodePair();
            pair.min = Integer.MAX_VALUE;
            pair.max = Integer.MIN_VALUE;
            pair.sum = 0;
            return pair;
        }
        NodePair pair = new NodePair();
        NodePair left = getSum(node.left);
        NodePair right = getSum(node.right);

        if (left.max < node.val && node.val < right.min) {
            pair.min = Math.min(node.val, Math.min(left.min, right.min));
            pair.max = Math.max(node.val, Math.max(left.max, right.max));
            pair.sum = node.val + left.sum + right.sum;
            maxSum = Math.max(maxSum, pair.sum);
        } else {
            pair.min = Integer.MIN_VALUE;
            pair.max = Integer.MAX_VALUE;
            pair.sum = Math.max(left.sum, right.sum);
        }
        return pair;
    }

    public int maxSumBST(TreeNode root) {
        getSum(root);
        return maxSum > 0 ? maxSum : 0;
    }
}
