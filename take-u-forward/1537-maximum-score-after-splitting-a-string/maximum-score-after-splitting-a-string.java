class Solution {
    public int maxScore(String s) {
        int zeros = 0, ones = 0, max = 0;
        for(int ind = 0; ind < s.length(); ind++)
            ones += s.charAt(ind) == '1' ? 1 : 0;
        for(int ind = 0; ind < s.length()-1; ind++) {
            if(s.charAt(ind) == '0')
                zeros += 1;
            else
                ones -= 1;
            max = Math.max(zeros+ones, max);
        }
        return max;
    }
}