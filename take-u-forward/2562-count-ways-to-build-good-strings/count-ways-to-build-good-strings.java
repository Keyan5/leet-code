class Solution {
    private int low, high, zero, one;
    private final HashMap<Integer, Integer> memo = new HashMap<>();
    private final int MOD = 1_000_000_007;
    public int countGoodStrings(int low, int high, int zero, int one) {
        this.low = low;
        this.high = high;
        this.zero = zero;
        this.one = one;
        return dfs(0);
    }

    private int dfs(int len) {
        if(memo.containsKey(len)) return memo.get(len);
        if(len > high)  return 0;
        long count = low <= len ? 1l : 0l;
        memo.put(len, (int)((count + dfs(len+one) + dfs(len+zero)) % MOD));
        return memo.get(len);
    }
}