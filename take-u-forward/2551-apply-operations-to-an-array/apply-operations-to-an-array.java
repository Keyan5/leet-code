class Solution {
    public int[] applyOperations(int[] nums) {
        int len = nums.length;
        for(int ind=0; ind<len-1; ind++) {
            if(nums[ind] == nums[ind+1]) {
                nums[ind] *= 2;
                nums[ind+1] = 0;         
            }
        }
        int pos = 0;
        for(int ind=0; ind<len; ind++) {
            if(nums[ind]!=0)
                nums[pos++] = nums[ind];
        }
        for(int ind=pos; ind<len; ind++)
            nums[ind] = 0;
        return nums;
    }
}