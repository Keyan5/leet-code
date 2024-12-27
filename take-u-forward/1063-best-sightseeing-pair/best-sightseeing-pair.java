class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int len = values.length;
        int max = 0, result = 0;
        for(int ind=0; ind<len; ind++) {
            result = Math.max(result, max+values[ind]-ind);
            max = Math.max(max, values[ind]+ind);
        }
        return result;
    }
}