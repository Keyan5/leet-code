class Solution {
    public boolean check(int[] nums) {
        int arrEnd = 0;
        int len = nums.length;
        for(int ind=len-1; ind>0; ind--) {
            if(nums[ind] < nums[ind-1]) {
                arrEnd = ind;
                break;
            }
        }
        for(int ind=0; ind<arrEnd; ind++) {
            if(nums[ind] < nums[ind == 0 ? len-1: ind-1])
                return false;
        }
        return true;
    }
}