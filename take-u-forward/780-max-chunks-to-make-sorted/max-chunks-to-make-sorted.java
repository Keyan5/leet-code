class Solution {
    public int maxChunksToSorted(int[] arr) {
        int chunks = 0, max = 0;
        for(int ind=0; ind<arr.length; ind++) {
            max = Math.max(max, arr[ind]);
            if(max == ind)
                chunks++;
        }
        return chunks;
    }
}