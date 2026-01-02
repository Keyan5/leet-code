class Solution {
    public int repeatedNTimes(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int ind=0; ind<nums.length; ind++) {
            int currentFreq = freq.getOrDefault(nums[ind], 0) + 1;
            freq.put(nums[ind], currentFreq);
            if(currentFreq > 1) {
                return nums[ind];
            }
        }
        return -1;
    }
}