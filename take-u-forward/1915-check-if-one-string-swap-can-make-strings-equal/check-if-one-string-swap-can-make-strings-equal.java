class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int len = s1.length(), missMatch = 0;
        int freq1[] = new int[26];
        int freq2[] = new int[26];
        for(int ind=0; ind<len; ind++) {
            if(s1.charAt(ind) != s2.charAt(ind)) {
                missMatch++;
                freq1[(s1.charAt(ind)-'a')%26]++;
                freq2[(s2.charAt(ind)-'a')%26]++;
            }
        }
        for(int ind=0; ind<26; ind++) {
            if(freq1[ind] != freq2[ind])
                return false;
        }
        return missMatch == 2 || missMatch == 0;
    }
}