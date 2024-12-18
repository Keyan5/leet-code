class Solution {
    public int[] finalPrices(int[] prices) {
        for(int idx=0; idx<prices.length; idx++) {
            for(int jidx=idx+1; jidx<prices.length; jidx++) {
                if(prices[idx]>=prices[jidx]) {
                    prices[idx] -= prices[jidx];
                    break;
                }
            }
        }
        return prices;
    }
}