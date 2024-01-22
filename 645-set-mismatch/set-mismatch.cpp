class Solution {
public:
    vector<int> findErrorNums(vector<int>& nums) {
        int n = nums.size();
        long x = 0;
        long y = 0;
        for(int i=1; i<=n; i++)
        {
            int ele = nums[i-1];
            x += ele - i;
            y += ele*ele - i*i;
        }
        int missing = (y - x*x)/(2*x);
        int duplicate = missing + x;
        return { duplicate, missing };
    }
};