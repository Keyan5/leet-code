class Solution {
    public int maxScore(String s) {
        int zeros = 0, ones = 0, best = Integer.MIN_VALUE;
        for(int ind = 0; ind < s.length()-1; ind++) {
            if(s.charAt(ind) == '0')
                zeros++;
            else
                ones++;
            best = Math.max(zeros-ones, best);
        }
        if(s.charAt(s.length() - 1) == '1')
            ones++;
        return ones + best;
    }
}