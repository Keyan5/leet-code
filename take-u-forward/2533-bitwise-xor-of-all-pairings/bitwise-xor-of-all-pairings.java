class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if(len1%2 == 0 && len2%2 == 0)
            return 0;
        int ans = 0;
        if(len2%2 == 1)
            for(int num: nums1) 
                ans ^= num;
        if(len1%2 == 1)
            for(int num: nums2) 
                ans ^= num;
        return ans;
    }
}