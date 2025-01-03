class Solution {
    public int waysToSplitArray(int[] nums) {
        long right = 0, sum = 0;
        for(int num: nums)
            right += num;
        int ans = 0;
        for(int ind=0; ind<nums.length-1; ind++) {
            right -= nums[ind];
            sum += nums[ind];
            if(sum >= right) ans++;
        }
        return ans;
    }
}