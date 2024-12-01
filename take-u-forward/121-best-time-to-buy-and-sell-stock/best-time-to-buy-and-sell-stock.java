class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int left_ind = 0, right_ind = 0;
        int maxi = 0;
        for(int ind=0; ind<len; ind++) {
            int ele = prices[ind];
            if(ele < prices[left_ind]) {
                left_ind = ind;
                if(right_ind < left_ind)        // preventing selling before buying
                    right_ind = left_ind;
            }
            else if(ele > prices[right_ind]) {
                right_ind = ind;
            }
            maxi = Math.max(maxi, prices[right_ind] - prices[left_ind]); 
        }
        return maxi;
    }
}