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
    private int count = 0;

    public int countPairs(TreeNode root, int distance) {
        Map<TreeNode, List<TreeNode>> nodePaths = new HashMap<>();
        List<TreeNode> leafNodes = new ArrayList<>();
        findLeaves(root, new ArrayList<>(), leafNodes, nodePaths);
        int result = 0;
        for (int i = 0; i < leafNodes.size(); i++) {
            for (int j = i + 1; j < leafNodes.size(); j++) {
                List<TreeNode> pathI = nodePaths.get(leafNodes.get(i));
                List<TreeNode> pathJ = nodePaths.get(leafNodes.get(j));
                for (int k = 0; k < Math.min(pathI.size(), pathJ.size()); k++) {
                    if (pathI.get(k) != pathJ.get(k)) {
                        int dist = pathI.size() - k + pathJ.size() - k;
                        if (dist <= distance) result++;
                        break;
                    }
                }
            }
        }
        return result;
    }

    private void findLeaves(TreeNode node, List<TreeNode> currentPath, List<TreeNode> leafNodes, Map<TreeNode, List<TreeNode>> nodePaths) {
        if (node == null) return;
        List<TreeNode> newPath = new ArrayList<>(currentPath);
        newPath.add(node);
        if (node.left == null && node.right == null) {
            nodePaths.put(node, newPath);
            leafNodes.add(node);
            return;
        }
        findLeaves(node.left, newPath, leafNodes, nodePaths);
        findLeaves(node.right, newPath, leafNodes, nodePaths);
    }
}