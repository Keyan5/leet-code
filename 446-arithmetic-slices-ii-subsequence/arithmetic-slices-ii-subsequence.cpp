class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        int len = nums.size();
        int res = 0;
        vector<unordered_map<int,int>> dp(len);
        for(int i=0; i<len; i++)
        {
            for(int j=0; j<i; j++)
            {
                long long diff = 1l*nums[i] - nums[j];
                if(diff>INT_MAX || diff<INT_MIN)
                    continue;
                dp[i][diff] += 1 + dp[j][diff];
                res += dp[j][diff];
            }
        }
        return res;
    }
};