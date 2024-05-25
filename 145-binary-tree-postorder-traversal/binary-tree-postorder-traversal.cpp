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
    vector<int> postorderTraversal(TreeNode* root) {
        stack<TreeNode*> stak({root});
        stack<bool> vis({false});
        vector<int> res;

        while(!stak.empty()) {
            TreeNode* curr = stak.top();
            bool visited = vis.top();
            vis.pop(),stak.pop();
            if(curr) {
                if(visited) {
                    res.push_back(curr->val);
                }
                else {
                    stak.push(curr);
                    vis.push(true);
                    stak.push(curr->right);
                    vis.push(false);
                    stak.push(curr->left);
                    vis.push(false);
                }
            }
        }
        return res;
    }
};