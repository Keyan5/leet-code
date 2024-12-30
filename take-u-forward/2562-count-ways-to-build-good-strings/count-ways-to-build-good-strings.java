class Solution {
    private final int MOD = 1_000_000_007;
    public int countGoodStrings(int low, int high, int zero, int one) {
        if(one > zero)
            return countGoodStrings(low, high, one, zero);
        int[] table = new int[high+1];
        table[0] = 1;
        int count = 0;
        for(int len = 1; len <= high; len++) {
            if(len >= zero)
                table[len] += table[len-zero] + table[len-one];
            else if(len >= one)
                table[len] += table[len-one];
            table[len] %= MOD;
            if(low <= len)
                count = (count + table[len]) % MOD;
        }
        return count;
    }
}