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
    public int minimumOperations(TreeNode root) {
        int swapCount = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            int[] currentLevelElements = new int[len];
            for(int ind=0; ind<len; ind++) {
                TreeNode node = queue.poll();
                currentLevelElements[ind] = node.val;
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            swapCount += calculateSwapCount(currentLevelElements, len);
        }
        return swapCount;
    }

    public int calculateSwapCount(int[] original, int len) {
        int swaps = 0;
        int[] target = original.clone();
        Arrays.sort(original);

        HashMap<Integer, Integer> pos = new HashMap<>();
        for(int ind=0; ind<len; ind++)
            pos.put(original[ind], ind);

        for(int ind=0; ind<len; ind++) {
            if(original[ind] != target[ind]) {
                swaps++;

                int currPos = pos.get(target[ind]);
                pos.put(original[ind], currPos);
                original[currPos] = original[ind];
            }
        }
        return swaps;
    }
}