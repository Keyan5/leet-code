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
            boolean[] isPresent = new boolean[26];
            for(int j=minIndices[ind]+1; j<maxIndices[ind]; j++) {
                int charPos = s.charAt(j) - 97;
                if(!isPresent[charPos]) {
                    isPresent[charPos] = true;
                    count++;
                }
            }
        }
        return count;
    }
}