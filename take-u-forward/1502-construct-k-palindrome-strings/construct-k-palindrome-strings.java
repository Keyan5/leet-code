class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length() < k)
            return false;
        int[] freq = new int[26];
        for(int ind=0; ind<s.length(); ind++)
            freq[s.charAt(ind)-'a']++;
        int oddOccurence = 0;
        for(int ind=0; ind<26; ind++)
            oddOccurence += freq[ind]%2;
        return oddOccurence <= k;
    }
}