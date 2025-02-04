class Solution {
    public int maxAscendingSum(int[] nums) {
        int sum = nums[0];
        int max = nums[0];
        for(int ind=1; ind<nums.length; ind++) {
            if(nums[ind-1] >= nums[ind])
                sum = 0;
            sum += nums[ind];
            max = Math.max(max, sum);
        }
        return max;
    }
}