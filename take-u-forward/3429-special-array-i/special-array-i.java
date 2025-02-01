class Solution {
    public boolean isArraySpecial(int[] nums) {
        for(int ind=0; ind<nums.length-1; ind++) {
            if(nums[ind]%2 == nums[ind+1]%2)
                return false;
        }
        return true;
    }
}