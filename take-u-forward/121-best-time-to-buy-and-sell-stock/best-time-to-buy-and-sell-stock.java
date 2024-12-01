class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int buy = prices[0], profit = 0;
        for(int ind=1; ind<len; ind++) {
            if(prices[ind] < buy)
                buy = prices[ind];
            else if(prices[ind]-buy > profit)
                profit = prices[ind]-buy;
        }
        return profit;
    }
}