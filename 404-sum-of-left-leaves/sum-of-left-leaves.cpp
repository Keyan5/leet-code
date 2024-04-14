/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int res = 0;
    bool isLeaf(TreeNode* node) {
        if(node && !node->left && !node->right)
            return true;
        return false;
    }
    int sumOfLeftLeaves(TreeNode* root) {
        if(!root)
            return 0;
        if(isLeaf(root->left))
            res += root->left->val;
        else
            sumOfLeftLeaves(root->left);
        sumOfLeftLeaves(root->right);
        return res;
    }
};