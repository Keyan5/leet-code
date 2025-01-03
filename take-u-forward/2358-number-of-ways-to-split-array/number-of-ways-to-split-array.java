class Solution {
    public int waysToSplitArray(int[] nums) {
        long right = 0, left = 0;
        for(int num: nums)
            right += num;
        int count = 0;
        for(int ind=0; ind<nums.length-1; ind++) {
            right -= nums[ind];
            left += nums[ind];
            if(left >= right) count++;
        }
        return count;
    }
}