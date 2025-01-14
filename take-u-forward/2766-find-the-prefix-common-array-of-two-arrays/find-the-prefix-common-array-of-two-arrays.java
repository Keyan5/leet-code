class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int len = A.length;
        int[] ans = new int[len];
        int[] freq = new int[len];
        for(int ind=0; ind<len; ind++) {
            if(ind > 0)
                ans[ind] += ans[ind-1];
            if(++freq[A[ind]-1] == 2)
                ans[ind]++;
            if(++freq[B[ind]-1] == 2)
                ans[ind]++;
        }
        return ans;
    }
}