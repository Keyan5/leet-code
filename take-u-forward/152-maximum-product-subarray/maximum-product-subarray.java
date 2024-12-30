class Solution {
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int max = 1, min = 1;
        for(int num: nums) {
            int maxMul = max * num;
            int minMul = min * num;
            max = Math.max(maxMul, Math.max(minMul, num));
            min = Math.min(maxMul, Math.min(minMul, num));
            result = Math.max(result, max);
        }
        return result;
    }
}