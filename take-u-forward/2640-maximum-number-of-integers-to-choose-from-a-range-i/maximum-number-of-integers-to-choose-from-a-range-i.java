class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> bannedSet = new HashSet<>();
        for(Integer ele: banned)
            bannedSet.add(ele);
        int count = 0;
        for(int num=1; num<=n; num++) {
            if(!bannedSet.contains(num)) {
                maxSum -= num;
                if(maxSum < 0)
                    break;
                count++;
            }
        }
        return count;
    }
}