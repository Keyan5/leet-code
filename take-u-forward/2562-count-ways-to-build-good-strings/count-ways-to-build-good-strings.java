class Solution {
    private final int MOD = 1_000_000_007;
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] table = new int[high+1];
        table[0] = 1;
        int count = 0;
        for(int len = 0; len <= high; len++) {
            if(len+zero <= high)
                table[len+zero] = (int)((0L + table[len+zero] + table[len]) % MOD);
            if(len+one <= high)
                table[len+one] = (int)((0L + table[len+one] + table[len]) % MOD);
            if(low <= len)
                count = (int)((0L + count + table[len]) % MOD);
        }
        return count;
    }
}