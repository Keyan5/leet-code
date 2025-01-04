class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] minIndices = new int[26];
        int[] maxIndices = new int[26];
        Arrays.fill(minIndices, -1);
        for(int ind=0; ind<s.length(); ind++) {
            int charPos = s.charAt(ind) - 97;
            if(minIndices[charPos] == -1)
                minIndices[charPos] = ind;
            maxIndices[charPos] = ind;
        }
        int count = 0;
        for(int ind=0; ind<26; ind++) {
            if(minIndices[ind] == -1) 
                continue;
            Set<Character> uniqueCharsInBetween = new HashSet<>();
            for(int j=minIndices[ind]+1; j<maxIndices[ind]; j++)
                uniqueCharsInBetween.add(s.charAt(j));
            count += uniqueCharsInBetween.size();
        }
        return count;
    }
}