class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] prefixSum = new int[words.length];
        prefixSum[0] = canCount(words[0]) ? 1 : 0;
        for(int ind=1; ind<words.length; ind++) {
            prefixSum[ind] += prefixSum[ind-1];
            if(canCount(words[ind]))
                prefixSum[ind]++;
        }
        int[] ans = new int[queries.length];
        for(int ind=0; ind<queries.length; ind++) {
            int[] query = queries[ind];
            ans[ind] += prefixSum[query[1]];
            if(query[0] > 0)
                ans[ind] -= prefixSum[query[0] - 1];
        }
        return ans;
    }
    public boolean canCount(String word) {
        return isVowel(word.charAt(0)) && isVowel(word.charAt(word.length()-1));
    }
    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}