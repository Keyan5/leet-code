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
    unordered_map<int, vector<int>> adjacent_nodes;
    int amountOfTime(TreeNode* root, int start) {
        dfs(root);
        queue<int> infected;
        unordered_set<int> visited;
        infected.push(start);
        int res = -1;
        while(!infected.empty()) {
            int queueLen = infected.size();
            while(queueLen--)
            {
                int currInfected = infected.front();
                infected.pop();
                visited.insert(currInfected);
                for(const auto &neighbour: adjacent_nodes[currInfected])
                    if(visited.find(neighbour) == visited.end())
                        infected.push(neighbour);
            }
            res++;
        }
        return res;
    }
    void dfs(TreeNode* root) {
        if(!root)
            return;
        int currVal = root->val;
        if(root->left)
        {
            int leftVal = root->left->val;
            adjacent_nodes[currVal].push_back(leftVal);
            adjacent_nodes[leftVal].push_back(currVal);
            dfs(root->left);
        }
        if(root->right) {
            int rightVal = root->right->val;
            adjacent_nodes[currVal].push_back(rightVal);
            adjacent_nodes[rightVal].push_back(currVal);
            dfs(root->right);
        }
    }
};