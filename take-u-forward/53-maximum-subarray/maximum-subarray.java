class Solution {
    public int maxSubArray(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        for(int ele: nums) {
            sum += ele;
            maxi = Math.max(sum, maxi); 
            if(sum < 0)
                sum = 0;
        }
        return maxi;
    }
}