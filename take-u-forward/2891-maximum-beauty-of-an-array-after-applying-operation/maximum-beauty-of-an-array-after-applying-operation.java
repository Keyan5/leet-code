class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int start = 0, end;
        int res = 0;
        for(end=0; end<nums.length; end++) {
            while(nums[end]-nums[start]>2*k)
                start++;
            res = Math.max(res, end-start+1);
        }
        return res;
    }
}