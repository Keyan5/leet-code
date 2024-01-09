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
    bool leafSimilar(TreeNode* root1, TreeNode* root2) {
        stringstream leaves1;
        stringstream leaves2;
        inOrder(root1, leaves1);
        inOrder(root2, leaves2);
        return leaves1.str() == leaves2.str();
    }
    void inOrder(TreeNode * root, stringstream &leaves) {
        if(!root)
            return;
        inOrder(root->left, leaves);
        if(!root->left && !root->right)
            leaves << root->val << " ";
        inOrder(root->right, leaves);
    }
};