class Solution {
    public int minimumLength(String s) {
        int[] freqs = new int[26];
        for(char curr: s.toCharArray())
            freqs[curr-'a']++;
        int len = 0;
        for(int freq: freqs) {
            if(freq == 0) continue;
            len += freq%2 == 0 ? 2 : 1;
        }
        return len;
    }
}