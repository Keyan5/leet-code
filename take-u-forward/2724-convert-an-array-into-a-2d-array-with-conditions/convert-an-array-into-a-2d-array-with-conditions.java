class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        int freq[] = new int[nums.length + 1];
        int max = 0;
        for(int num: nums)
        {
            if(++freq[num] > max)
            {
                max++;
                res.add(new ArrayList<Integer>());
            }
        }
        for(int ind=0; ind < freq.length ; ind++)
        {
            for(int jind=0; jind < freq[ind]; jind++)
            {
                res.get(jind).add(ind);
            }
        }
        return res;
    }
}