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
    queue<int> leaves;
    bool res = true;
    bool leafSimilar(TreeNode* root1, TreeNode* root2) {
        inOrder(root1, true);
        inOrder(root2, false);
        return res && leaves.empty();
    }
    void inOrder(TreeNode * root, bool produce) {
        if(!res || !root)
            return;
        if(!root->left && !root->right)
        {
            if(produce)
                leaves.push(root->val);
            else if(leaves.front() == root->val)
                leaves.pop();
            else
                res = false;
            return;
        }
        inOrder(root->left, produce);
        inOrder(root->right, produce);
    }
};