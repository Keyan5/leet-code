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
    final int SHIFT = 20;
    final int MASK = 0xFFFFF;
    public int minimumOperations(TreeNode root) {
        int swaps = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            long[] nodes = new long[len];
            for(int ind=0; ind<len; ind++) {
                TreeNode node = queue.poll();
                nodes[ind] = ((long) node.val << SHIFT) + ind;
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            Arrays.sort(nodes);
            for(int ind=0; ind<len; ind++) {
                int origPos = (int) (nodes[ind] & MASK);
                if(origPos != ind) {
                    swaps++;
                    long temp = nodes[ind];
                    nodes[ind--] = nodes[origPos];
                    nodes[origPos] = temp;
                }
            }
        }
        return swaps;
    }
}