class Solution {
public:
    int majorityElement(vector<int>& nums) {
        unordered_map<int, int> freq;
        int maxi = INT_MIN;
        int maxi_num = nums[0];
        for(int num: nums)
        {
            if(maxi < ++freq[num])
            {
                maxi = freq[num];
                maxi_num = num;
            }
        }
        return maxi_num;
    }
};