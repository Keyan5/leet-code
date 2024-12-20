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
    public TreeNode reverseOddLevels(TreeNode root) {
        int level = 0;
        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            if(level%2 == 1) {
                for(int ind=0; ind<len/2; ind++) {
                    int temp = queue.get(ind).val;
                    queue.get(ind).val = queue.get(len-ind-1).val;
                    queue.get(len-ind-1).val = temp;
                }
            }
            while(len-->0) {
                TreeNode head = queue.remove(0);
                if(head.left != null) {     // perfect binary tree
                    queue.add(head.left);
                    queue.add(head.right);
                }
            }
            level++;
        }
        return root;
    }
}