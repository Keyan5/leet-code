class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length() < k)
            return false;
        int oddOccurence = 0;
        for(char c: s.toCharArray())
            oddOccurence ^= 1 << c-'a';
        return Integer.bitCount(oddOccurence) <= k;
    }
}