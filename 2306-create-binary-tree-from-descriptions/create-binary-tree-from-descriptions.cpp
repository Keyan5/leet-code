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
    TreeNode* createBinaryTree(vector<vector<int>>& descriptions) {
        unordered_map<int, TreeNode*> treeMap;
        unordered_set<int> children;
        for(auto description: descriptions) {
            int parent = description[0];
            int child = description[1];
            int isLeft = description[2];
            if(!treeMap[parent])
                treeMap[parent] = new TreeNode(parent);
            if(!treeMap[child])
                treeMap[child] = new TreeNode(child);
            if(isLeft)
                treeMap[parent]->left = treeMap[child];
            else
                treeMap[parent]->right = treeMap[child];
            children.insert(child);
        }
        for(auto [key, value]: treeMap) {
            if(children.find(key) == children.end())
                return treeMap[key];
        }
        return nullptr;
    }
};