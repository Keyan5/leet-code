class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length() < k)
            return false;
        int oddOccurence = 0;
        for(int ind=0; ind<s.length(); ind++)
            oddOccurence ^= 1 << s.charAt(ind)-'a';
        return Integer.bitCount(oddOccurence) <= k;
    }
}