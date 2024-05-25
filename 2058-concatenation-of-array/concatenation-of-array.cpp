class Solution {
public:
    vector<int> getConcatenation(vector<int>& nums) {
        int len = nums.size();
        vector<int> ans;
        for(int i=0; i<2*len; i++)
            ans.push_back(nums[i%len]);
        return ans;
    }
};