class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int start = 0, end;
        for(end=0; end<nums.length; end++)
            if(nums[end]-nums[start]>2*k)
                start++;
        return end - start;
    }
}