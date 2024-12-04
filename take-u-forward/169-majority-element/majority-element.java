class Solution {
    public int majorityElement(int[] nums) {
        int ele = nums[0];
        int count = 1;
        for(int ind=1; ind < nums.length; ind++) {
            if(count == 0)
                ele = nums[ind];
            count += nums[ind]==ele ? 1 : -1;
        }
        return ele;
    }
}