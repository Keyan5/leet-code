class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map <int,int> mapping;
        for(int i=0;i<nums.size();i++)
        {
            if(mapping[target-nums[i]]>0)
                return vector<int>{mapping[target-nums[i]]-1,i};
            mapping[nums[i]] = i+1;
        }
        return vector<int>{};//empty
    }
};