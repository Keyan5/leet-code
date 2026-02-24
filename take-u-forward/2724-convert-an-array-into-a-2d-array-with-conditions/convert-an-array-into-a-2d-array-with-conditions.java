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
            res.get(freq[num]-1).add(num);
        }
        return res;
    }
}