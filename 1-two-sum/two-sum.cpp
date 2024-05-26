class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> numToInd;
        for(int i=0; i<nums.size(); i++) {
            int compKey = target-nums[i];
            if(numToInd[compKey])
                return vector<int> {numToInd[compKey]-1,i};
            numToInd[nums[i]] = i+1;
        }
        return nums;
    }
};