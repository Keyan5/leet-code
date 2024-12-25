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
    private final List<Integer> result = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        if(root == null)
            return result;
        dfs(root, 0);
        return result;
    }

    public void dfs(TreeNode currNode, int level) {
        if(currNode == null)
            return;
        if(result.size() == level)
            result.add(Integer.MIN_VALUE);
        result.set(level, Math.max(currNode.val, result.get(level)));
        dfs(currNode.left, level+1);
        dfs(currNode.right, level+1);
    }
}