class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int max = 1;
        int len1 = 1, len2 = 1;
        for(int ind=0; ind<nums.length-1; ind++) {
            len1 = nums[ind] < nums[ind+1] ? len1+1 : 1;
            len2 = nums[ind] > nums[ind+1] ? len2+1 : 1;
            max = Math.max(max, Math.max(len1, len2));
        }
        return max;
    }
}