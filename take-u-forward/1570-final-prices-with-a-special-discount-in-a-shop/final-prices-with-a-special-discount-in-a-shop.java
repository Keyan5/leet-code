class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack();
        for(int idx=0; idx<prices.length; idx++) {
            while(!stack.isEmpty() && prices[stack.peek()] >= prices[idx])
                prices[stack.pop()] -= prices[idx];
            stack.push(idx);
        }
        return prices;
    }
}