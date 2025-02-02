class Solution {
    public boolean check(int[] nums) {
        int cliffCount = 0, len = nums.length;
        for(int ind=0; ind<len; ind++) {
            if(nums[ind] > nums[(ind+1)%len])
                cliffCount++;
        }
        return cliffCount <= 1;
    }
}